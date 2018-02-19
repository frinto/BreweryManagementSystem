/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.DeliveryDB;
import dataaccess.ProductDB;
import domainmodel.Delivery;
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
            DeliveryDB db = new DeliveryDB();
            List<Delivery> delivery = db.getAll();
            request.setAttribute("deliverys", delivery);
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
                    /////////////////////////////////////////////////////////////
                    //FOR TESTING PURPOSESES EMPID IS SET TO 1
                    ////////////////////////////////////////////////////////////
                    DeliveryDB deliveryDB = new DeliveryDB();
                    String companyName = request.getParameter("companyName");
//                    HttpSession session = request.getSession();
//                    int empId = (int) session.getAttribute("userId");
                    int empId = 1; /////////////////////////////////////////////HERE
                    String dateS = request.getParameter("date");
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
                    Delivery delivery = new Delivery();
                    delivery = new Delivery(delivery.getDeliveryId(), companyName, empId, date);
                    deliveryDB.insert(delivery);
                    //Product
                    ProductDB productDB = new ProductDB();
                    String qty[] = request.getParameterValues("qty");
                    String productName[] = request.getParameterValues("productName");
                    ArrayList<Product> product = new ArrayList();
                    for (int i = 0; i < qty.length && i < productName.length; i++)
                    {
                        ProductPK pk = new ProductPK(productName[i], delivery.getDeliveryId());
                        Product p = new Product(pk, Integer.parseInt(qty[i]));
                        productDB.insert(p);

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
