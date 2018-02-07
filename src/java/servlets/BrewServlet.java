/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.RecipeDB;
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
public class BrewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            //Get list of recipes from database to display in dropdown menu

            RecipeDB recipeDB = new RecipeDB();
            HttpSession session = request.getSession();
            session.setAttribute("newBrew", null);
            session.setAttribute("recipes", null);
      

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

            getServletContext().getRequestDispatcher("/WEB-INF/brew.jsp").forward(request, response);
        } catch (BrewDBException ex) {
            Logger.getLogger(BrewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     

    }

}
