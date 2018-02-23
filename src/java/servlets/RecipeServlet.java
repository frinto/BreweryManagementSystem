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
            
            RecipeDB recipeDB = new RecipeDB();
            
            List<Recipe> recipeList = recipeDB.getAll();
            session.setAttribute("recipeList",recipeList);
            
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
