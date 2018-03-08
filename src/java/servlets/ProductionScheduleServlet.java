/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.ProductionScheduleDB;
import domainmodel.Productionschedule;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "ProductionScheduleServlet", urlPatterns = {"/ProductionScheduleServlet"})
public class ProductionScheduleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductionScheduleDB productionScheduleDatabase = new ProductionScheduleDB();

        try {
            List<Productionschedule> productionSchedules = productionScheduleDatabase.getAllInventory();

            request.setAttribute("productionSchedules", productionSchedules);

            getServletContext().getRequestDispatcher("/WEB-INF/productionSchedule.jsp").forward(request, response);

        } catch (BrewDBException ex) {
            Logger.getLogger(FinishedInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error retrieving production schedule list from database");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/productionSchedule.jsp").forward(request, response);

    }
}
