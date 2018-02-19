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
public class ViewDeliveryServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        try
        {
            Object deliveryId = request.getParameter("deliveryId");
            ProductDB productDB = new ProductDB();
            List<Product> product = productDB.getByDeliveryId((String) deliveryId);
            request.setAttribute("products", product);
        } catch (BrewDBException ex)
        {
            Logger.getLogger(DeliveryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/viewDelivery.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String action = request.getParameter("action");

        switch (action)
        {
            case "edit":
                break;
            case "remove":
                break;
        }
        response.sendRedirect("viewDelivery");
    }

}
