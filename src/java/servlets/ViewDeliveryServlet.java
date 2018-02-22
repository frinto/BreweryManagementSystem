/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.DeliveryDB;
import dataaccess.FinishedInventoryDB;
import dataaccess.ProductDB;
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
public class ViewDeliveryServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        try
        {
            Object deliveryId = request.getParameter("deliveryId");
            //get delivery information
            DeliveryDB deliveryDB = new DeliveryDB();
            List<Delivery> delivery = deliveryDB.getByDeliveryId((String) deliveryId);
            request.setAttribute("deliverys", delivery);
            request.setAttribute("companyName", delivery.get(0).getCompanyName());
            request.setAttribute("date", delivery.get(0).getDate());
            
            
            //make a list of products for the jsp
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

        try
        {
            String action = request.getParameter("action");
            
            switch (action)
            {
                case "edit":
                    //get all qtys
                    String[] qty = request.getParameterValues("qty");
                    
                    //make a list of all products from the database
                    Object deliveryId = request.getParameter("deliveryId");
                    ProductDB productDB = new ProductDB();
                    List<Product> product = productDB.getByDeliveryId((String) deliveryId);
                    //get the list of finished products from the database
                    FinishedInventoryDB finishedInventoryDB = new FinishedInventoryDB();
                    List<Finishedproduct> finishedProduct = finishedInventoryDB.getAllInventory();
                    
                    //update product values
                    for (int i = 0; i < product.size(); i++)
                    {
                        int difference = product.get(i).getQty() - Integer.parseInt(qty[i]);
                        product.get(i).setQty(Integer.parseInt(qty[i]));
                        productDB.update(product.get(i));
                        
                        //remove product from finished goods
                        for (int x = 0; x < finishedProduct.size(); x++)
                        {
                            if (product.get(i).getProductName().equals(finishedProduct.get(x).getProductName()))
                            {
                                finishedProduct.get(x).setQty(finishedProduct.get(x).getQty() + difference);
                            }
                        }
                    }
                    break;
                case "remove":
                    break;
            }
            response.sendRedirect("viewDelivery");
        } catch (BrewDBException ex)
        {
            Logger.getLogger(ViewDeliveryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
