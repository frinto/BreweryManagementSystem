/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.TankDB;
import dataaccess.TransferDB;
import domainmodel.Fv;
import domainmodel.Sv;
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
        //set current date in user input field
        setTodaysDate(request);
        
        //retrieve all transfers from database
        retrieveAllTransfers(request);
        
        getServletContext().getRequestDispatcher("/WEB-INF/tankTransfer.jsp").forward(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getParameter("action");
        if (action!=null && action.equals("add")) {
            
            //create variables
            TransferDB transferDB = new TransferDB();
            TankDB tankDB = new TankDB();
            Date date;
            String brand;
            double volume;
            int toSV;
            int fromFV;
            double correction = 0;
            String dateString;
            Transfer transfer;
            String isEmpty;
            
            //execute all logic
            try {
                dateString = request.getParameter("date");
                fromFV = Integer.parseInt(request.getParameter("fromFV"));
                toSV = Integer.parseInt(request.getParameter("toSV"));
                volume = Double.parseDouble(request.getParameter("volume"));
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                isEmpty = request.getParameter("isEmpty");
                
                
                //ensure user input is valid
                Sv sv = tankDB.getSV(toSV);
                Fv fv = tankDB.getFV(fromFV);
                double currentSvVolume = sv.getVolume();
                double currentFvVolume = fv.getVolume();
                
                //check that the fv is not empty
                if (currentFvVolume == 0) {
                    
                    //save user input values for page reload
                    saveUserInput(request, toSV, fromFV, volume, isEmpty);
                    
                    request.setAttribute("capacityMessage", "Selected FV is empty.");
                    throw new BrewDBException("");
                }
                
                int svCapacity = sv.getCapacity();
                double newVolume = currentSvVolume + volume;
                brand = fv.getBrand();
                
                //If the added volume pushes the SV's volume above capacity, display warning/save user input
                if (newVolume>svCapacity) {
                    
                    //save user input values for page reload
                    saveUserInput(request, toSV, fromFV, volume, isEmpty);
                    
                    double maxTransfer = svCapacity - currentSvVolume;
                    request.setAttribute("inputVolume", maxTransfer);
                    request.setAttribute("capacityMessage", "The maximum amount that can be transferred into SV " + toSV + " is " + maxTransfer);
                    throw new BrewDBException("");
                }
                
                //Add the volume transfered to the SV
                double newSvVolume = currentSvVolume + volume;
                sv.setVolume(newSvVolume);
                sv.setBrand(brand);
                //Brew# columns are wack so this is just a fill in
                sv.setBrew1(fv.getBrew1());
                sv.setBrew2(fv.getBrew2());
                sv.setBrew3(fv.getBrew3());
                tankDB.updateSV(sv);
                
                //Subtract the volume transfered from the FV
                //This value may be negative if there is a case where Gains are greater than amount left in the FV
                double newFvVolume = currentFvVolume - volume;
                fv.setVolume(newFvVolume);
                
                //Determine the possible volume correction, (+) Gain / (-) Loss
                //Set emptied fv fields to zero
                if (isEmpty != null && isEmpty.equals("on")) {
                    correction = volume - currentFvVolume;
                    fv.setVolume(0.0);
                    fv.setBrew1(0);
                    fv.setBrew2(0);
                    fv.setBrew3(0);
                    fv.setBrand(null);
                }
                
                tankDB.updateFV(fv);
                
                transfer = new Transfer(0, date, brand, fromFV, toSV, volume, correction);
                transferDB.insertTransfer(transfer);
                
            } catch (ParseException ex) {
                request.setAttribute("message", ex);
                Logger.getLogger(TankTransferServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrewDBException ex) {
                request.setAttribute("message", ex);
                Logger.getLogger(TankTransferServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            setTodaysDate(request);
            retrieveAllTransfers(request);
            getServletContext().getRequestDispatcher("/WEB-INF/tankTransfer.jsp").forward(request, response);
        }
    }
    
    // ----------------------- HELPER METHODS ----------------------------------- //
    
    private void setTodaysDate(HttpServletRequest request) {
        //set the current date to a variable so the Add A Transfer form has the current date pre-set
        //this is the required format to pre-set a date value in a date input field
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateToday = dateFormat.format(new Date());
        request.setAttribute("dateToday", dateToday);
    }

    private void retrieveAllTransfers(HttpServletRequest request) {
        TransferDB transferDB = new TransferDB();
        try {
            List<Transfer> transfers = transferDB.getAllTransfer();
            
            request.setAttribute("transfers", transfers);
            
        } catch (BrewDBException ex) {
            Logger.getLogger(TankStatusServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error retrieving transfers from database");
        }
    }

    private void saveUserInput(HttpServletRequest request, int toSV, int fromFV, double volume, String isEmpty) {
        request.setAttribute("inputSV", toSV);
        request.setAttribute("inputFV", fromFV);
        request.setAttribute("volume", volume);
        if (isEmpty != null && isEmpty.equals("on")) {
            request.setAttribute("checkedIsEmpty", "checked");
        }
        //causes Modal menu to popup on page load
        request.setAttribute("loadAddTransfer", "notNull");
    }
}
