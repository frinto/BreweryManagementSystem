/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.RawInventoryDB;
import domainmodel.Brewmaterials;
import domainmodel.Productionmaterial;
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
            List<Productionmaterial> productionMaterials = rawDatabase.getAllInventoryProductionMaterial();

            request.setAttribute("brewMaterials", brewMaterials);
            request.setAttribute("productionMaterials", productionMaterials);

        } catch (BrewDBException ex) {
            Logger.getLogger(RawInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error retrieving brew material list from database");

        }
        
        //**********************************************************************************************
        
        
         getServletContext().getRequestDispatcher("/WEB-INF/rawInventory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String actionBrewMaterial = request.getParameter("action");

        RawInventoryDB rawDatabase = new RawInventoryDB();

        if (actionBrewMaterial != null) {
            if (actionBrewMaterial.equals("updateBrewMaterials")) {
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
                    
                    //keep the production materials list
                    
                    List<Productionmaterial> productionMaterials = rawDatabase.getAllInventoryProductionMaterial();
                    
                    request.setAttribute("productionMaterials", productionMaterials);

                } catch (BrewDBException ex) {
                    Logger.getLogger(FinishedInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("message", "error updating brew material list from database");

                }
                
                getServletContext().getRequestDispatcher("/WEB-INF/rawInventory.jsp").forward(request, response);
            }
            if(actionBrewMaterial.equals("updateProductionMaterials"))
            {
               try {
                    List<Productionmaterial> productionMaterials = rawDatabase.getAllInventoryProductionMaterial();
                    int[] qty = new int[productionMaterials.size()];
                    for (int i = 0; i < productionMaterials.size(); i++) {

                        //name is the product name
                        //productQtyString get the string of the productname from jsp
                        //we then parse the productQtyString to an int quantity
                        String name = productionMaterials.get(i).getName();
                        String productQtyString = request.getParameter(name);
                        qty[i] = Integer.parseInt(productQtyString);
                    }
                    for (int i = 0; i < productionMaterials.size(); i++) {
                        productionMaterials.get(i).setQty(qty[i]);
                        rawDatabase.updateProductionMaterials(productionMaterials.get(i));
                    }
                    request.setAttribute("productionMaterials", productionMaterials);
                    
                    //keep the brew materials list
                    
                    List<Brewmaterials> brewMaterials = rawDatabase.getAllInventoryBrewMaterial();
                    request.setAttribute("brewMaterials", brewMaterials);

                } catch (BrewDBException ex) {
                    Logger.getLogger(FinishedInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("message", "error updating production material list from database");

                }
                
                getServletContext().getRequestDispatcher("/WEB-INF/rawInventory.jsp").forward(request, response); 
            }
        }
        
    }
}
