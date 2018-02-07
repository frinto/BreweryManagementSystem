/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.TransferDB;
import domainmodel.Transfer;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martin Czerwinski
 */
public class TankTransferServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        TransferDB transferDB = new TransferDB();
        
        try {
            List<Transfer> transfers = transferDB.getAllTransfer();
            
            request.setAttribute("transfers", transfers);
            
        } catch (BrewDBException ex) {
            Logger.getLogger(TankStatusServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error retrieving transfers from database");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/tankTransfer.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getParameter("action");
        if (action!=null && action.equals("add")) {
            //maybe a pop-up form for adding tank transfer
            response.sendRedirect("tankTransfer");
        }
//        getServletContext().getRequestDispatcher("/WEB-INF/tankTransfer.jsp").forward(request, response);
    }


}
