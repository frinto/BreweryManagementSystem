/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDB;
import dataaccess.BrewDBException;
import dataaccess.FinishedInventoryDB;
import domainmodel.Finishedproduct;
import dataaccess.ProductionDB;
import dataaccess.RawInventoryDB;
import domainmodel.Brew;
import domainmodel.Brewmaterials;
import domainmodel.Production;
import domainmodel.Productionmaterial;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 727525
 */
public class ReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FinishedInventoryDB finishedDatabase = new FinishedInventoryDB();
        RawInventoryDB rawInventoryDatabase = new RawInventoryDB();

        try {
            List<Finishedproduct> finishedProducts = finishedDatabase.getAllInventory();
            request.setAttribute("reportDataFinishedInventory", "Finished Inventory"); //title of chart
            request.setAttribute("finishedProducts", finishedProducts);
            
            List<Productionmaterial> productionMaterials = rawInventoryDatabase.getAllInventoryProductionMaterial();
            request.setAttribute("reportDataProductionMaterials", "Production Materials"); // title of chart
            request.setAttribute("productionMaterials", productionMaterials);
            
            List<Brewmaterials> brewMaterials = rawInventoryDatabase.getAllInventoryBrewMaterial();
            request.setAttribute("reportDataBrewMaterials", "Brew Materials"); // title of chart
            request.setAttribute("brewMaterials", brewMaterials);
            
            

        } catch (BrewDBException ex) {
            Logger.getLogger(FinishedInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error retrieving finished product list from database");

        }
        
        //Get the date of the beginning of the last week (7 days ago)
        //This is used to produce reports based on the last 7 days
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date previousWeekDate = cal.getTime();
        
        //The current date must be incremented by 1 so that the range ends at midnight (12:00am) of the current night
        Calendar calToday = Calendar.getInstance();
        calToday.add(Calendar.DATE, +1);
        Date todaysDate = calToday.getTime();
        
        //Report that shows the Weekly Production of Individual Items
        ProductionDB prodDB = new ProductionDB();
        List<Production> prodItemList;
        try {
            prodItemList = prodDB.getProdByDateRange(previousWeekDate, todaysDate);
            request.setAttribute("prodItemList", prodItemList);
        } catch (BrewDBException ex) {
            Logger.getLogger(ReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Report that shows Weekly Volume of Beer brewed based on Recipe
        BrewDB brewDB = new BrewDB();
        List<Brew> brewList;
        try {
            brewList = brewDB.getBrewByDateRange(previousWeekDate, todaysDate);
            List<String> currentRecipes;
            Set<String> currentUniqueRecipes = new HashSet<>();
            ArrayList<Double> brewVolumeList = new ArrayList<>();
            Map<String, Double> brewMap = new HashMap<>();
            
            for (Brew brew : brewList){
                currentUniqueRecipes.add(brew.getRecipeName());
            }
            
            for (String recipe : currentUniqueRecipes) {
                
                double volume = 0;
                
                for (Brew brew : brewList) {
                    
                    if (recipe.equals(brew.getRecipeName())) {
                        volume = volume + brew.getAllInVolume();
                    }
                    
                }
                brewMap.put(recipe,volume);
            }
            request.setAttribute("brewVolumeMap", brewMap);
        } catch (BrewDBException ex) {
            Logger.getLogger(ReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        request.setAttribute("reportData", "greetings from the backend!");
        getServletContext().getRequestDispatcher("/WEB-INF/reports.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
