/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.FinishedInventoryDB;
import domainmodel.Finishedproduct;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

        try {
            List<Finishedproduct> finishedProducts = finishedDatabase.getAllInventory();
            
            request.setAttribute("beachcomberqty", finishedProducts.get(0).getQty());
            request.setAttribute("black6qty", finishedProducts.get(1).getQty());
            request.setAttribute("blonde12qty", finishedProducts.get(2).getQty());
            request.setAttribute("blonde6qty", finishedProducts.get(3).getQty());
            request.setAttribute("bobbyqty", finishedProducts.get(4).getQty());
            request.setAttribute("gardenerqty", finishedProducts.get(5).getQty());
            request.setAttribute("neighbourqty", finishedProducts.get(6).getQty());
            request.setAttribute("witqty", finishedProducts.get(7).getQty());
            

        } catch (BrewDBException ex) {
            Logger.getLogger(FinishedInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error retrieving finished product list from database");

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
