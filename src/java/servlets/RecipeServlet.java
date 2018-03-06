/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.BrewMaterialsDB;
import dataaccess.RecipeDB;
import domainmodel.Brewmaterials;
import domainmodel.Recipe;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author 553817
 */
public class RecipeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String newRecipe = request.getParameter("newRecipe");
        if(newRecipe!=null)
        {
            session.setAttribute("newRecipe", newRecipe);
            getServletContext().getRequestDispatcher("/WEB-INF/recipe.jsp").forward(request, response);
            return;
        }
        
        try {
            
            //Grabbing the various lists from the database to display as options for the recipe.
            //The multiple brew materials lists are based on the type of material (Hops, malt, chemistry..
            
            BrewMaterialsDB materialDB = new BrewMaterialsDB();
            RecipeDB recipeDB = new RecipeDB();
            
            List<Brewmaterials> hopList = materialDB.getHops();
            List<Brewmaterials> maltList = materialDB.getMalt();
            List<Brewmaterials> chemicalList = materialDB.getChemicals();
            List<Recipe> recipeList = recipeDB.getAll();
            
            
            session.setAttribute("recipeList",recipeList);
            session.setAttribute("hopList", hopList);
            session.setAttribute("maltList", maltList);
            session.setAttribute("chemicalList", chemicalList);
            
            getServletContext().getRequestDispatcher("/WEB-INF/recipe.jsp").forward(request, response);
        } catch (BrewDBException ex) {
            Logger.getLogger(RecipeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        String newRecipe = request.getParameter("newRecipe");
        if(newRecipe!=null)
        {
            session.setAttribute("newRecipe", newRecipe);
        }
        
        float mashInTime = Float.parseFloat(request.getParameter("mashInTime"));
        float restTime = Float.parseFloat(request.getParameter("restTime"));
        float inTime = Float.parseFloat(request.getParameter("inTime"));
        float totalMashTime = Float.parseFloat(request.getParameter("totalMashTime"));
        float underletTime = Float.parseFloat(request.getParameter("underletTime"));
        float lauterRestTime = Float.parseFloat(request.getParameter("lauterRest"));
        float vorlaufTime = Float.parseFloat(request.getParameter("vorlaufTime"));
        float firstWortGrav = Float.parseFloat(request.getParameter("firstWortGrav"));
        float runOffTime = Float.parseFloat(request.getParameter("runOffTime"));
        float lastRunnings = Float.parseFloat(request.getParameter("lastRunnings"));
        float kettleFullVol = Float.parseFloat(request.getParameter("kettleFullVol"));
        float kettleFullGrav = Float.parseFloat(request.getParameter("kettleFullGrav"));
        float strikeOutGrav = Float.parseFloat(request.getParameter("strikeOutGrav"));
        float kettleStrikeOutVol = Float.parseFloat(request.getParameter("strikeOutVol"));
        float finalVolume = Float.parseFloat(request.getParameter("finalVolume"));
        
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
