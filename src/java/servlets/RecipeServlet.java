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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        String cancelRecipe = request.getParameter("cancelRecipe");
        if(cancelRecipe!=null)
        {
            session.setAttribute("newRecipe", null);
        }
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
        
        String recipeName = request.getParameter("recipeName");
        
        float mashInTemp = Float.parseFloat(request.getParameter("mashInTemp"));
        float mashInTime = Float.parseFloat(request.getParameter("mashInTime"));
        float mashWaterVolume = Float.parseFloat(request.getParameter("mashWaterVolume"));        
        float restTime = Float.parseFloat(request.getParameter("restTime"));
        float raiseToTemp = Float.parseFloat(request.getParameter("raiseToTemp"));
        float inTime = Float.parseFloat(request.getParameter("inTime"));
        float totalMashTime = Float.parseFloat(request.getParameter("totalMashTime"));
        float underletLitres = Float.parseFloat(request.getParameter("underletLitres"));
        float lauterRestTime = Float.parseFloat(request.getParameter("lauterRest"));
        float vorlaufTime = Float.parseFloat(request.getParameter("vorlaufTime"));
        float firstWortGrav = Float.parseFloat(request.getParameter("firstWortGrav"));
        float runOffTime = Float.parseFloat(request.getParameter("runOffTime"));
        float spargVol = Float.parseFloat(request.getParameter("spargVol"));
        float spargTemp = Float.parseFloat(request.getParameter("spargTemp"));
        float lastRunnings = Float.parseFloat(request.getParameter("lastRunnings"));
        float kettleFullVol = Float.parseFloat(request.getParameter("kettleFullVol"));
        float kettleFullGrav = Float.parseFloat(request.getParameter("kettleFullGrav"));
        float boilTime = Float.parseFloat(request.getParameter("boilTime"));
        float strikeOutVol = Float.parseFloat(request.getParameter("strikeOutVol"));
        float strikeOutGrav = Float.parseFloat(request.getParameter("strikeOutGrav"));
        float whirlPoolTime = Float.parseFloat(request.getParameter("whirlPoolTime"));
        float coolInTemp = Float.parseFloat(request.getParameter("coolInTemp"));
        float oxygenRate = Float.parseFloat(request.getParameter("oxygenRate"));
        float gypsumAmt = Float.parseFloat(request.getParameter("gypsumAmt"));
        float sodiumChlorideAmt = Float.parseFloat(request.getParameter("sodiumChlorideAmt"));
        float calciumChlorideAmt = Float.parseFloat(request.getParameter("calciumChlorideAmt"));
        float phosphAcidAmt = Float.parseFloat(request.getParameter("phosphAcidAmt"));
        float firstHopAmt=0;
        float secondHopAmt=0;
        float thirdHopAmt = 0;
        String firstHop = request.getParameter("firstHopList");
        if(firstHop.equals(""))
        {
            firstHop=null;
        }
        else
            firstHopAmt = Float.parseFloat(request.getParameter("firstHopAmt"));
            
        
        
     
        String secondHop = request.getParameter("secondhopList");
        if(secondHop.equals(""))
        {
            secondHop=null;
        }
        else
            secondHopAmt = Float.parseFloat(request.getParameter("secondHopAmt"));
            

        String thirdHop = request.getParameter("thirdHopList");
        if(thirdHop.equals(""))
        {
            thirdHop=null;
        }
        else
            thirdHopAmt = Float.parseFloat(request.getParameter("thirdHopAmt"));
            
  
        
        String baseMalt = request.getParameter("baseMaltList");
        float baseMaltAmt = Float.parseFloat(request.getParameter("baseMaltAmt"));
        String secondMalt = request.getParameter("secondMaltList");
        float secondMaltAmt = Float.parseFloat(request.getParameter("secondMaltAmt"));
        String thirdMalt = request.getParameter("thirdMaltList");
        float thirdMaltAmt = Float.parseFloat(request.getParameter("thirdMaltAmt"));
        String fourthMalt = request.getParameter("fourthMaltList");
        float fourthMaltAmt = Float.parseFloat(request.getParameter("fourthMaltAmt"));
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = sdf.format(new Date());
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        } catch (ParseException ex) {
            Logger.getLogger(BrewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        RecipeDB recipeDB = new RecipeDB();
        
        Recipe recipe = new Recipe(recipeName,date,mashInTemp,mashInTime,mashWaterVolume,restTime,raiseToTemp,inTime,
        totalMashTime,underletLitres,lauterRestTime,vorlaufTime,firstWortGrav,runOffTime,spargVol,spargTemp,
        lastRunnings,kettleFullVol,kettleFullGrav,boilTime,strikeOutVol,strikeOutGrav,whirlPoolTime,
        coolInTemp,oxygenRate,gypsumAmt,sodiumChlorideAmt,calciumChlorideAmt,phosphAcidAmt,firstHop,firstHopAmt,
        secondHop,secondHopAmt,thirdHop,thirdHopAmt,baseMalt,baseMaltAmt,secondMalt,secondMaltAmt,thirdMalt,
        thirdMaltAmt,fourthMalt,fourthMaltAmt);
        
        
        try {
        
        
             recipeDB.insert(recipe);
             session.setAttribute("newRecipe", null);
             getServletContext().getRequestDispatcher("/WEB-INF/recipe.jsp").forward(request, response);
        } catch (BrewDBException ex) {
            Logger.getLogger(RecipeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        

        
        

        
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
