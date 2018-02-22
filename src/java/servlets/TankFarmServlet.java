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
public class TankFarmServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //set current date in user input field
        setTodaysDate(request);
        
        //retrieve all transfers and tanks from database. This is for user display
        retrieveAllTransfers(request);
        retrieveAllTanks(request);
        
        getServletContext().getRequestDispatcher("/WEB-INF/tankFarm.jsp").forward(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getParameter("action");
        if (action!=null && action.equals("addTransfer")) {
            
            //clear user messages
            request.setAttribute("message", "");
            request.setAttribute("capacityMessage", "");
            
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
            String isEmpty;
            
            //execute all logic
            try {
                dateString = request.getParameter("date");
                fromFV = Integer.parseInt(request.getParameter("fromFV"));
                toSV = Integer.parseInt(request.getParameter("toSV"));
                volume = Double.parseDouble(request.getParameter("volume"));
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                isEmpty = request.getParameter("isEmpty");
                
                //show the user an error if volume is 0
                if (volume == 0) {
                    saveUserInput(request, toSV, fromFV, volume, isEmpty);
                    request.setAttribute("capacityMessage", "Volume cannot be zero");
                    throw new BrewDBException();
                }
                
                //ensure user input is valid
                Sv sv = tankDB.getSV(toSV);
                Fv fv = tankDB.getFV(fromFV);
                double currentSvVolume = sv.getVolume();
                double currentFvVolume = fv.getVolume();
                int svCapacity = sv.getCapacity();
                
                //check that the fv is not empty
                if (currentFvVolume == 0) {
                    //save user input values for page reload
                    saveUserInput(request, toSV, fromFV, volume, isEmpty);
                    request.setAttribute("capacityMessage", "FV " + fromFV + " is empty.");
                    throw new BrewDBException("");
                }
                
                //check that the SV is not full
                if (svCapacity == currentSvVolume) {
                    saveUserInput(request, toSV, fromFV, volume, isEmpty);
                    request.setAttribute("capacityMessage", "SV " + toSV + " is full.");
                    throw new BrewDBException();
                }
                
                double newSvVolume = currentSvVolume + volume;
                brand = fv.getBrand();
                
                //If the added volume pushes the SV's volume above capacity, display warning/save user input
                if (newSvVolume>svCapacity) {
                    
                    //save user input values for page reload
                    saveUserInput(request, toSV, fromFV, volume, isEmpty);
                    
                    double maxTransfer = svCapacity - currentSvVolume;
                    request.setAttribute("inputVolume", maxTransfer);
                    request.setAttribute("capacityMessage", "The maximum amount that can be transferred into SV " + toSV + " is " + maxTransfer);
                    throw new BrewDBException("");
                }
                
                //Add the volume transfered to the SV
                sv.setVolume(newSvVolume);
                sv.setBrand(brand);
                //simply transfer the brew # data from the fv to the sv, overridin what is currently in the sv
                sv.setBrew1(fv.getBrew1());
                sv.setBrew2(fv.getBrew2());
                sv.setBrew3(fv.getBrew3());
                
                //Determine the possible volume correction, (+) Gain / (-) Loss
                //Set emptied fv's fields to zero
                if (isEmpty != null && isEmpty.equals("on")) {
                    correction = volume - currentFvVolume;
                    fv.setVolume(0.0);
                    fv.setBrew1(0);
                    fv.setBrew2(0);
                    fv.setBrew3(0);
                    fv.setBrand(null);
                } else {
                    //Subtract the volume transfered from the FV
                    //This value may be negative if there is a case where there is a positive correction (gains in beer) and still beer in the tank.
                    double newFvVolume = currentFvVolume - volume;
                    if (newFvVolume<0) {
                        request.setAttribute("message", "Please note that Fermenting Vessel " + fromFV + "'s volume has been set to a negative number. This represents that there has been more beer produced from this tank than anticipated. The negative number indicates the amount of unanticipated extra beer. And there is still more unanticipated beer in the tank!");
                    }
                    fv.setVolume(newFvVolume);
                }
                
                //do the changes
                tankDB.updateSV(sv);
                tankDB.updateFV(fv);
                transferDB.insertTransfer(new Transfer(0, date, brand, fromFV, toSV, volume, correction));
                request.setAttribute("message", "Success!");
                
            } catch (ParseException ex) {
                request.setAttribute("message", ex);
                Logger.getLogger(TankFarmServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrewDBException ex) {
                Logger.getLogger(TankFarmServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            setTodaysDate(request);
            retrieveAllTransfers(request);
            retrieveAllTanks(request);
            getServletContext().getRequestDispatcher("/WEB-INF/tankFarm.jsp").forward(request, response);
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
            Logger.getLogger(TankFarmServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error retrieving transfers from database");
        }
    }
    
    //this method saves user input and makes the modal appear on page load
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

    private void retrieveAllTanks(HttpServletRequest request) {
        TankDB tankDB = new TankDB();
        
        try {
            List<Fv> fvs = tankDB.getAllFV();
            List<Sv> svs = tankDB.getAllSV();
            
            request.setAttribute("svs", svs);
            request.setAttribute("fvs", fvs);            
        } catch (BrewDBException ex) {
            Logger.getLogger(TankFarmServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error retrieving tank lists (fv and sv) from database");
        }
    }
}
