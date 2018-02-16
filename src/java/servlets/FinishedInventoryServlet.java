/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.FinishedInventoryDB;
import domainmodel.Finishedproduct;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "FinishedInventoryServlet", urlPatterns = {"/FinishedInventoryServlet"})
public class FinishedInventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FinishedInventoryDB finishedDatabase = new FinishedInventoryDB();

        try {
            List<Finishedproduct> finishedProducts = finishedDatabase.getAllInventory();

            request.setAttribute("finishedProducts", finishedProducts);

            for (int i = 0; i < finishedProducts.size(); i++) {

                request.setAttribute("updateCount", finishedProducts.get(i).getQty());
            }

            getServletContext().getRequestDispatcher("/WEB-INF/finishedInventory.jsp").forward(request, response);

        } catch (BrewDBException ex) {
            Logger.getLogger(FinishedInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error retrieving finished product list from database");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FinishedInventoryDB finishedDatabase = new FinishedInventoryDB();

        try {
            List<Finishedproduct> finishedProducts = finishedDatabase.getAllInventory();
            int[] qty = new int[finishedProducts.size()];
            for (int i = 0; i < finishedProducts.size(); i++) {

                //name is the product name
                //productQtyString get the string of the productname from jsp
                //we then parse the productQtyString to an int quantity
                String name = finishedProducts.get(i).getProductName();
                String productQtyString = request.getParameter(name);
                qty[i] = Integer.parseInt(productQtyString);
            }
            for (int i = 0; i < finishedProducts.size(); i++) {
                finishedProducts.get(i).setQty(qty[i]);
                finishedDatabase.update(finishedProducts.get(i));
            }
            request.setAttribute("finishedProducts", finishedProducts);

        } catch (BrewDBException ex) {
            Logger.getLogger(FinishedInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error updating finished product list from database");

        }

        getServletContext().getRequestDispatcher("/WEB-INF/finishedInventory.jsp").forward(request, response);
    }
}
