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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

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
        } catch (BrewDBException ex)
        {
            Logger.getLogger(DeliveryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/delivery.jsp").forward(request, response);
    }

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
//                    int empId = (int) session.getAttribute("empId");
//THIS IS HARDCODED SINCE THE LOGIN CURRENTLY DOES NOT WORK FOR SOME REASON THIS CAN BE REMOVED ONCE THE SITE WORKS PROPPERLY TALK TO JESSIE
                    int empId = 1;
                    String dateS = request.getParameter("date");
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
                    Delivery delivery = new Delivery();
                    delivery = new Delivery(delivery.getDeliveryId(), companyName, empId, date);
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
                            if(pName1.equals(pName2))
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

}
