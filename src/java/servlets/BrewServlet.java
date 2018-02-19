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
            String startDateStr = request.getParameter("brewDate");
            
            if(startDateStr==null)
            {
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String startDate = sdf.format(new Date());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
                
                session.setAttribute("brewDate",date);
            }
            if(startDateStr!=null)
            {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startDate = sdf.parse(startDateStr);
                session.setAttribute("brewDate", startDate);
            } catch (ParseException ex) {
                Logger.getLogger(BrewServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
            

            String cancelBrew = request.getParameter("cancelBrew");
            if (cancelBrew != null) {
                session.setAttribute("recipe", null);
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
            session.setAttribute("fvs", fvs);

            List<Brew> brews = brewDB.getAll();
            if (brews != null) {
                session.setAttribute("brews", brews);
            }

            getServletContext().getRequestDispatcher("/WEB-INF/brew.jsp").forward(request, response);
        } catch (BrewDBException ex) {
            Logger.getLogger(BrewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
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

        String empId = (String) session.getAttribute("empId");

        int fvSelection = Integer.parseInt(request.getParameter("fvList"));
        Date date = new Date();

        Recipe recipe = (Recipe) session.getAttribute("recipe");

        String recipeName = recipe.getRecipeName();

        Brew brew = new Brew();
        //Absurdly long constructor for a brew object

        brew = new Brew(brew.getBrewId(), date, mashInTime, restTime, inTime, totalMashTime, underletTime,
                lauterRestTime, vorlaufTime, firstWortGrav, runOffTime, lastRunnings, kettleFullVol, kettleFullGrav,
                kettleStrikeOutVol, strikeOutGrav, finalVolume, Integer.parseInt(empId), fvSelection, recipeName);

        try {
            
            
            TankDB tankDB = new TankDB();

            Fv fv = tankDB.getFV(brew.getFvId());

            fv.setBrand(brew.getRecipeName());
            double volume = fv.getVolume();
            double newVolume = volume + (brew.getAllInVolume() * 100);
            if (newVolume > fv.getCapacity()) {
                request.setAttribute("errorMessage", "Error, fermenter is over capacity. Please redo EVERYTHING");
                getServletContext().getRequestDispatcher("/WEB-INF/brew.jsp").forward(request, response);
                return;
                

            }
            fv.setVolume(newVolume);

            if (fv.getBrew1() == 0) {
                fv.setBrew1(brew.getBrewId());
            } else if (fv.getBrew1() != 0 && fv.getBrew2() == 0) {
                fv.setBrew2(brew.getBrewId());
            } else if (fv.getBrew3() == 0 && fv.getBrew1() != 0 && fv.getBrew2() != 0) {
                fv.setBrew2(brew.getBrewId());
            } else {
                request.setAttribute("errorMessage", "Error, fermenter already has 3 brews. Please redo EVERYTHING");
                getServletContext().getRequestDispatcher("/WEB-INF/brew.jsp").forward(request, response);
                return;
            }

            tankDB.updateFV(fv);
            brewDB.insert(brew);

            session.setAttribute("recipe", null);
            List<Brew> brews = brewDB.getAll();
            session.setAttribute("brews", brews);

            getServletContext().getRequestDispatcher("/WEB-INF/brew.jsp").forward(request, response);

        } catch (BrewDBException ex) {
            Logger.getLogger(BrewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //        -----------------------------------Helper Methods----------------------------------------

    private void updateFV(Brew brew, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TankDB tankDB = new TankDB();

        try {
            Fv fv = tankDB.getFV(brew.getFvId());

            fv.setBrand(brew.getRecipeName());
            double volume = fv.getVolume();
            double newVolume = volume + (brew.getAllInVolume() * 100);
            if (newVolume > fv.getCapacity()) {
                request.setAttribute("errorMessage", "Error, fermenter is over capacity. Please redo EVERYTHING");
                getServletContext().getRequestDispatcher("/WEB-INF/brew.jsp").forward(request, response);
                return;

            }
            fv.setVolume(newVolume);

            if (fv.getBrew1() == 0) {
                fv.setBrew1(brew.getBrewId());
            } else if (fv.getBrew1() != 0 && fv.getBrew2() == 0) {
                fv.setBrew2(brew.getBrewId());
            } else if (fv.getBrew3() == 0 && fv.getBrew1() != 0 && fv.getBrew2() != 0) {
                fv.setBrew2(brew.getBrewId());
            } else {
                request.setAttribute("errorMessage", "Error, fermenter already has 3 brews. Please redo EVERYTHING");
                getServletContext().getRequestDispatcher("/WEB-INF/brew.jsp").forward(request, response);
            }

            tankDB.updateFV(fv);

        } catch (BrewDBException ex) {
            Logger.getLogger(BrewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
