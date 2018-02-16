/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.RawInventoryDB;
import domainmodel.Brewmaterials;
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
@WebServlet(name = "RawInventoryServlet", urlPatterns = {"/RawInventoryServlet"})
public class RawInventoryServlet extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        RawInventoryDB rawDatabase = new RawInventoryDB();

        try {
            List<Brewmaterials> brewMaterials = rawDatabase.getAllInventoryBrewMaterial();

            request.setAttribute("brewMaterials", brewMaterials);

            getServletContext().getRequestDispatcher("/WEB-INF/rawInventory.jsp").forward(request, response);

        } catch (BrewDBException ex) {
            Logger.getLogger(RawInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error retrieving brew material list from database");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RawInventoryDB rawDatabase = new RawInventoryDB();

        try {
            List<Brewmaterials> brewMaterials = rawDatabase.getAllInventoryBrewMaterial();
            double[] qty = new double[brewMaterials.size()];
            for (int i = 0; i < brewMaterials.size(); i++) {

                //name is the product name
                //productQtyString get the string of the productname from jsp
                //we then parse the productQtyString to an int quantity
                String name = brewMaterials.get(i).getName();
                String productQtyString = request.getParameter(name);
                qty[i] = Double.parseDouble(productQtyString);
            }
            for (int i = 0; i < brewMaterials.size(); i++) {
                brewMaterials.get(i).setQty(qty[i]);
                rawDatabase.updateBrewMaterials(brewMaterials.get(i));
            }
            request.setAttribute("brewMaterials", brewMaterials);

        } catch (BrewDBException ex) {
            Logger.getLogger(FinishedInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error updating brew material list from database");

        }

        getServletContext().getRequestDispatcher("/WEB-INF/rawInventory.jsp").forward(request, response);
        
        
    }

}
