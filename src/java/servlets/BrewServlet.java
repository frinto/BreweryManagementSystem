/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDB;
import dataaccess.BrewDBException;
import dataaccess.BrewMaterialsDB;
import dataaccess.RecipeDB;
import dataaccess.TankDB;
import domainmodel.Brew;
import domainmodel.Brewmaterials;
import domainmodel.Fv;
import domainmodel.Recipe;
import java.io.IOException;
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
        //Absurdly long constructor for a brew object
        
        brew = new Brew(brew.getBrewId(),date,mashInTime,restTime,inTime,totalMashTime,underletTime,
        lauterRestTime,vorlaufTime,firstWortGrav,runOffTime,lastRunnings,kettleFullVol,kettleFullGrav,
                kettleStrikeOutVol,strikeOutGrav,finalVolume,Integer.parseInt(empId),fvSelection,recipeName);
        
        
        try {
            brewDB.insert(brew);
            updateInventory(recipe);
            session.setAttribute("recipe", null);
            List<Brew> brews = brewDB.getAll();
            session.setAttribute("brews", brews);
            
            getServletContext().getRequestDispatcher("/WEB-INF/brew.jsp").forward(request, response);
            
        } catch (BrewDBException ex) {
            Logger.getLogger(BrewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        


    }
    //        -----------------------------------Helper Methods----------------------------------------
    
            
    private void updateInventory(Recipe recipe)
    {
        BrewMaterialsDB bmDB = new BrewMaterialsDB();
        Brewmaterials bm_one;
        Brewmaterials bm_two;
        Brewmaterials bm_three;
        Brewmaterials bm_four;
        Brewmaterials bm_five;
        Brewmaterials bm_six;
        Brewmaterials bm_seven;
        Brewmaterials bm_eight;
        Brewmaterials bm_nine;
        Brewmaterials bm_ten;
        Brewmaterials bm_eleven;
 
        
        
        
        
        try {
            bm_one = bmDB.getbrewmaterials(recipe.getBaseMalt());
            double qty_one = recipe.getBaseMaltAmt();          
            bm_one.useMaterial(qty_one);
            bmDB.update(bm_one);
            
            
            bm_two = bmDB.getbrewmaterials(recipe.getSecondMalt());
            if(bm_two!=null)
            {
                double qty_two = recipe.getSecondMaltAmt();
                bm_one.useMaterial(qty_two);
                bmDB.update(bm_two);
            }
            
            bm_three = bmDB.getbrewmaterials(recipe.getThirdMalt());
            if(bm_three!=null)
            {
                double qty_three = recipe.getThirdMaltAmt();
                bm_three.useMaterial(qty_three);
                bmDB.update(bm_three);
            }
            bm_four = bmDB.getbrewmaterials(recipe.getFourthMalt());
            if(bm_four!=null)
            {
                double qty_four = recipe.getFourthMaltAmt();
                bm_four.useMaterial(qty_four);
                bmDB.update(bm_four);
            }
            bm_five = bmDB.getbrewmaterials(recipe.getFirstHop());
            if(bm_five!=null)
            {
            double qty_five = recipe.getFirstHopAmt();
            bm_five.useMaterial(qty_five);
            bmDB.update(bm_five);
            }
            
            bm_six = bmDB.getbrewmaterials(recipe.getSecondHop());
            if(bm_six!=null)
            {
            double qty_six = recipe.getSecondHopAmt();
            bm_six.useMaterial(qty_six);
            bmDB.update(bm_six);
            }
            
            bm_seven = bmDB.getbrewmaterials(recipe.getThirdHop());
            if(bm_seven!=null)
            {
            double qty_seven = recipe.getThirdHopAmt();
            bm_seven.useMaterial(qty_seven);
            bmDB.update(bm_seven);
            }
            
            bm_eight = bmDB.getbrewmaterials("Gypsum");
            if(bm_eight!=null)
            {
                double qty_eight = recipe.getGypsumAmt();
                bm_eight.useMaterial(qty_eight);
                bmDB.update(bm_eight);
            }
            bm_nine = bmDB.getbrewmaterials("SodiumChloride");
            if(bm_nine!=null)
            {
                double qty_nine = recipe.getSodiumChlorideAmt();
                bm_nine.useMaterial(qty_nine);
                bmDB.update(bm_nine);
            }
            bm_ten = bmDB.getbrewmaterials("")
            
            
 

            
            
            
        } catch (BrewDBException ex) {
            Logger.getLogger(BrewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
