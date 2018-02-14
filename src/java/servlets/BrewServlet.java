/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDB;
import dataaccess.BrewDBException;
import dataaccess.RecipeDB;
import dataaccess.TankDB;
import domainmodel.Brew;
import domainmodel.Fv;
import domainmodel.Recipe;
import java.io.IOException;
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
public class BrewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            //Get list of recipes from database to display in dropdown menu

            RecipeDB recipeDB = new RecipeDB();
            TankDB tankDB = new TankDB();
            BrewDB brewDB = new BrewDB();
            HttpSession session = request.getSession();
            session.setAttribute("newBrew", null);
            session.setAttribute("recipes", null);
            
      
            String cancelBrew = request.getParameter("cancelBrew");
            if(cancelBrew!=null)
            {
                session.setAttribute("recipe",null);
            }
            String newBrew = request.getParameter("newBrew");
            session.setAttribute("newBrew", newBrew);

            if (newBrew != null) {
                List<Recipe> recipes = recipeDB.getAll();

                session.setAttribute("recipes", recipes);
            }
            //-----------------------------------After Recipe is selected-----------------------------

            String selectedRecipe = request.getParameter("recipeList");
            if (selectedRecipe != null) {
                
                Recipe recipe = recipeDB.getRecipe(selectedRecipe);
                session.setAttribute("recipe", recipe);
                
                
            }
            List<Fv> fvs = tankDB.getAllFV();
            session.setAttribute("fvs",fvs);
            
            List<Brew> brews = brewDB.getAll();
            if(brews!=null)
            {
            session.setAttribute("brews", brews);
            }

            getServletContext().getRequestDispatcher("/WEB-INF/brew.jsp").forward(request, response);
        } catch (BrewDBException ex) {
            Logger.getLogger(BrewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        BrewDB brewDB = new BrewDB();
        
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
        
        String empId = (String)session.getAttribute("empId");
        
        int fvSelection = Integer.parseInt(request.getParameter("fvList"));
        Date date = new Date();
        
        
        Recipe recipe = (Recipe)session.getAttribute("recipe");
        
        String recipeName = recipe.getRecipeName();
        
        Brew brew = new Brew();
        
        brew = new Brew(brew.getBrewId(),date,mashInTime,restTime,inTime,totalMashTime,underletTime,
        lauterRestTime,vorlaufTime,firstWortGrav,runOffTime,lastRunnings,kettleFullVol,kettleFullGrav,kettleStrikeOutVol,strikeOutGrav,finalVolume,Integer.parseInt(empId),fvSelection,recipeName);
        
        
        try {
            brewDB.insert(brew);
            session.setAttribute("recipe", null);
            List<Brew> brews = brewDB.getAll();
            session.setAttribute("brews", brews);
            getServletContext().getRequestDispatcher("/WEB-INF/brew.jsp").forward(request, response);
            
        } catch (BrewDBException ex) {
            Logger.getLogger(BrewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
                
        
        

     

    }

}
