/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.TankDB;
import domainmodel.Fv;
import domainmodel.Sv;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@WebServlet(name = "TankStatusServlet", urlPatterns = {"/TankStatusServlet"})
public class TankStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        TankDB tankDatabase = new TankDB();
        
        try {
            List<Fv> fvs = tankDatabase.getAllFV();
            List<Sv> svs = tankDatabase.getAllSV();
            
            request.setAttribute("svs", svs);
            request.setAttribute("fvs", fvs);
            
            
        } catch (BrewDBException ex) {
            Logger.getLogger(TankStatusServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error retrieving tank lists(fv and sv) from database");
                     
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/tankStatus.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        getServletContext().getRequestDispatcher("/WEB-INF/tankStatus.jsp").forward(request, response);
    }
}
