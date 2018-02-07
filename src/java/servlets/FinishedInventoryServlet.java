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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "FinishedInventoryServlet", urlPatterns = {"/FinishedInventoryServlet"})
public class FinishedInventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FinishedInventoryDB finishedDatabase = new FinishedInventoryDB();

        try {
            List<Finishedproduct> finishedProducts = finishedDatabase.getAllInventory();

            request.setAttribute("finishedProducts", finishedProducts);
            request.setAttribute("message", "it works!");

        } catch (BrewDBException ex) {
            Logger.getLogger(FinishedInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error retrieving finished product list from database");

        }

        getServletContext().getRequestDispatcher("/WEB-INF/finishedInventory.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
