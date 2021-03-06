/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.AccountDB;
import dataaccess.BrewDBException;
import dataaccess.DeliveryDB;
import dataaccess.FinishedInventoryDB;
import dataaccess.ProductDB;
import domainmodel.Account;
import domainmodel.Delivery;
import domainmodel.Employee;
import domainmodel.Finishedproduct;
import domainmodel.Product;
import domainmodel.ProductPK;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author reare
 */
public class DeliveryServlet extends HttpServlet
{
 /**
  * This method obtains the deliveries and accounts for the specified date and sends them to the jsp to be shown on the page
  * 
  * @param request a request variable from the jsp
  * @param response a response variable from the jsp
  * @throws ServletException this occurs if there is an error with the servlet
  * @throws IOException this occurs if there is an error with reading any data
  */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        setTodaysDate(request);
        HttpSession session = request.getSession();
        String startDateStr = request.getParameter("deliveryDate");
        if (startDateStr == null)
        {

            try
            {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String startDate = sdf.format(new Date());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);

                session.setAttribute("deliveryDate", date);
            } catch (ParseException ex)
            {
                Logger.getLogger(DeliveryServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (startDateStr != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try
            {
                Date startDate = sdf.parse(startDateStr);
                session.setAttribute("deliveryDate", startDate);
            } catch (ParseException ex)
            {
                Logger.getLogger(BrewServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try
        {
            //get a list of deliveries for the jsp
            DeliveryDB db = new DeliveryDB();
            List<Delivery> delivery = db.getAll();
            request.setAttribute("deliverys", delivery);

            //get a list of accounts for the jsp
            AccountDB accountDB = new AccountDB();
            List<Account> account = accountDB.getAll();
            request.setAttribute("accounts", account);

            //get a list of finished goods for the jsp
            FinishedInventoryDB finishedInventoryDB = new FinishedInventoryDB();
            List<Finishedproduct> finishedProduct = finishedInventoryDB.getAllInventory();
            request.setAttribute("finishedProducts", finishedProduct);
        } catch (BrewDBException ex)
        {
            Logger.getLogger(DeliveryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/delivery.jsp").forward(request, response);
    }
/**
 * This gives the ability to add a new delivery
 * 
 * @param request a request variable from the jsp
 * @param response a response variable from the jsp
 * @throws ServletException this occurs if there is an error with the servlet
 * @throws IOException this occurs if there is an error with reading any data
 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String action = request.getParameter("action");

        switch (action)
        {
            case "add":
                try
                {
                    //Delivery
                    //Creates a delivery object and puts the products for the delivery into it, this information is taken from the delivery servlet
                    DeliveryDB deliveryDB = new DeliveryDB();
                    String companyName = request.getParameter("companyName");
                    HttpSession session = request.getSession();
                    Employee employee = (Employee) session.getAttribute("currentEmployee");
//THIS IS HARDCODED SINCE THE LOGIN CURRENTLY DOES NOT WORK FOR SOME REASON THIS CAN BE REMOVED ONCE THE SITE WORKS PROPPERLY TALK TO JESSIE
//                    int empId = 1;
                    String dateS = request.getParameter("date");
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
                    Delivery delivery = new Delivery();
                    delivery = new Delivery(delivery.getDeliveryId(), companyName, employee.getEmpId(), date);
                    deliveryDB.insert(delivery);

                    //Product
                    ProductDB productDB = new ProductDB();
                    String qty[] = request.getParameterValues("qty");
                    String productName[] = request.getParameterValues("productName");
                    for (int i = 0; i < qty.length && i < productName.length; i++)
                    {
                        ProductPK pk = new ProductPK(productName[i], delivery.getDeliveryId());
                        Product p = new Product(pk, Integer.parseInt(qty[i]));
                        productDB.insert(p);

                    }

                    //Remove from finished Goods
                    FinishedInventoryDB finishedInventoryDB = new FinishedInventoryDB();
                    List<Finishedproduct> finishedProduct = finishedInventoryDB.getAllInventory();
                    for (int i = 0; i < finishedProduct.size(); i++)
                    {
                        for (int x = 0; x < productName.length; x++)
                        {
                            String pName1 = productName[x];
                            String pName2 = finishedProduct.get(i).getProductName();
                            if (pName1.equals(pName2))
                            {
                                finishedProduct.get(i).setQty(finishedProduct.get(i).getQty() - Integer.parseInt(qty[x]));
                                finishedInventoryDB.update(finishedProduct.get(i));
                            }
                        }
                    }
                } catch (ParseException ex)
                {
                    Logger.getLogger(DeliveryServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BrewDBException ex)
                {
                    Logger.getLogger(DeliveryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
        response.sendRedirect("delivery");
    }
/**
 * This grabs the current date and sends it to the jsp
 * 
 * @param request 
 */
    private void setTodaysDate(HttpServletRequest request)
    {
        //set the current date to a variable so the Add A Transfer form has the current date pre-set
        //this is the required format to pre-set a date value in a date input field
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateToday = dateFormat.format(new Date());
        request.setAttribute("dateToday", dateToday);
    }
}
