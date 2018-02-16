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

/**
 *
 * @author Martin Czerwinski
 */
public class TankTransferServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //set the current date to a variable so the Add A Transfer form has the current date pre-set
        //this is the required format to pre-set a date value in a date input field
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateToday = dateFormat.format(new Date());
        request.setAttribute("dateToday", dateToday);
        
        //get all transfers
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
            TransferDB transferDB = new TransferDB();
            Date date;
            long volume;
            int toSV;
            int fromFV;
            String dateString;
            Transfer transfer = new Transfer();
            
            try {
                dateString = request.getParameter("date");
                fromFV = Integer.parseInt(request.getParameter("fromFV"));
                toSV = Integer.parseInt(request.getParameter("toSV"));
                volume = Long.parseLong(request.getParameter("volume"));
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                
                transfer = new Transfer(transfer.getTransferId(), date, fromFV, toSV, volume);
                transferDB.insertTransfer(transfer);
            } catch (ParseException ex) {
                request.setAttribute("message", ex);
                Logger.getLogger(TankTransferServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrewDBException ex) {
                request.setAttribute("message", ex);
                Logger.getLogger(TankTransferServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            response.sendRedirect("tankTransfer");
        }
//        getServletContext().getRequestDispatcher("/WEB-INF/tankTransfer.jsp").forward(request, response);
    }


}
