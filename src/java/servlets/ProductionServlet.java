/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.ProductionDB;
import domainmodel.Production;
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
 * @author 579957
 */
public class ProductionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            ProductionDB prodDB = new ProductionDB();
            
            List<Production> prodList = prodDB.getAllProduction();
            
            request.setAttribute("prod", prodList);
            
            getServletContext().getRequestDispatcher("/WEB-INF/production.jsp").forward(request, response);
        } catch (BrewDBException ex) {
            Logger.getLogger(ProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if(action.equals("add")) {
            request.setAttribute("action", action);
            getServletContext().getRequestDispatcher("/WEB-INF/production.jsp").forward(request, response);
        }
    }
}
