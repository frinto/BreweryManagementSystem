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
        String date = request.getParameter("date");
        String productionType = request.getParameter("productionType");
        String quantity = request.getParameter("quantity");
        String svNumber = request.getParameter("svNumber");
        String employeeId = request.getParameter("employeeId");
        Production production = new Production();
        ProductionDB prodDB = new ProductionDB();
        //navigates to the production form to submit a new production
        if (action.equals("add")) {
            request.setAttribute("action", action);
            getServletContext().getRequestDispatcher("/WEB-INF/production.jsp").forward(request, response);
        } //Add a new production to the database
        else if (action.equals("newProduction")) {
            try {
                //Production(Integer prodId, int quantity, Date date, int employeeId, int svNum, String productionType)
                Date formatDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                production = new Production(production.getProdId(), Integer.parseInt(quantity), formatDate, Integer.parseInt(employeeId), Integer.parseInt(svNumber), productionType);
                prodDB.insertProduction(production);
                List<Production> prodList = prodDB.getAllProduction();
                
                request.setAttribute("prod", prodList);
                request.setAttribute("message", "Production Submitted");
                getServletContext().getRequestDispatcher("/WEB-INF/production.jsp").forward(request, response);
                
            } catch (BrewDBException ex) {
                Logger.getLogger(ProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/production.jsp").forward(request, response);
        }
    }
}
