package servlets;

import dataaccess.BrewDB;
import dataaccess.BrewDBException;
import dataaccess.ProductionDB;
import dataaccess.TransferDB;
import domainmodel.Brew;
import domainmodel.Production;
import domainmodel.Transfer;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the servlet used to display the Reports page. It creates HashMap variables that are set as parameters to be used by Google Charts API to create our bar graphs.
 * @author Martin Czerwinski
 */
public class ReportProductionServlet extends HttpServlet {
    
    /**
     * Handles the HTTP <code>GET</code> method. All of the data for the charts is sent to the users web browser on page load.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        // ------------------------------------- Dates Used in Various Charts --------------------------- //
        //This is used to produce reports based on the last 7 days
        Calendar calWeek = Calendar.getInstance();
        calWeek.add(Calendar.DATE, -7);
        Date previousWeekDate = calWeek.getTime();
        
        //This is used to produce reports based on the last 30 days
        Calendar calMonth = Calendar.getInstance();
        calMonth.add(Calendar.DATE, -30);
        Date previousMonthDate = calMonth.getTime();
        
        //This is used to produce reports based on the last 365 days
        Calendar calYear = Calendar.getInstance();
        calYear.add(Calendar.DATE, -365);
        Date previousYearDate = calYear.getTime();
        
        //The current date must be incremented by 1 so that the range ends at midnight (12:00am) of the current night
        Calendar calToday = Calendar.getInstance();
        calToday.add(Calendar.DATE, +1);
        Date todaysDate = calToday.getTime();
        
        
        // -------------------------- Production of Finished Inventory Chart -------------------------------- //
        ProductionDB prodDB = new ProductionDB();
        List<Production> prodItemListWeek;
        List<Production> prodItemListMonth;
        List<Production> prodItemListYear;
        List<Production> prodItemListAllTime;
        try {
            prodItemListWeek = prodDB.getProdByDateRange(previousWeekDate, todaysDate);
            request.setAttribute("prodItemListWeek", prodItemListWeek);
            prodItemListMonth = prodDB.getProdByDateRange(previousMonthDate, todaysDate);
            request.setAttribute("prodItemListMonth", prodItemListMonth);
            prodItemListYear = prodDB.getProdByDateRange(previousYearDate, todaysDate);
            request.setAttribute("prodItemListYear", prodItemListYear);
            prodItemListAllTime = prodDB.getAllProduction();
            request.setAttribute("prodItemListAllTime", prodItemListAllTime);
        } catch (BrewDBException ex) {
            Logger.getLogger(ReportProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // ----------------------------- END Production of Finished Inventory Charts ------------------ //
        
        
        // ------------------------------- Total Volume by Brand Chart ---------------------- //
        BrewDB brewDB = new BrewDB();
        List<Brew> brewListWeek;
        List<Brew> brewListMonth;
        List<Brew> brewListYear;
        List<Brew> brewListAllTime;
        try {
            //Week List
            brewListWeek = brewDB.getBrewByDateRange(previousWeekDate, todaysDate);
            Set<String> currentRecipesWeek = new HashSet<>();
            Map<String, Double> brewMapWeek = new HashMap<>();
            
            for (Brew brew : brewListWeek){
                currentRecipesWeek.add(brew.getRecipeName());
            }
            
            for (String recipe : currentRecipesWeek) {
                
                double volume = 0;
                
                for (Brew brew : brewListWeek) {
                    
                    if (recipe.equals(brew.getRecipeName())) {
                        volume = volume + brew.getAllInVolume();
                    }
                }
                brewMapWeek.put(recipe,volume);
            }
            request.setAttribute("brewVolumeMapWeek", brewMapWeek);
            
            //Month List
            brewListMonth = brewDB.getBrewByDateRange(previousMonthDate, todaysDate);
            Set<String> currentRecipesMonth = new HashSet<>();
            Map<String, Double> brewMapMonth = new HashMap<>();
            
            for (Brew brew : brewListMonth){
                currentRecipesMonth.add(brew.getRecipeName());
            }
            
            for (String recipe : currentRecipesMonth) {
                
                double volume = 0;
                
                for (Brew brew : brewListMonth) {
                    
                    if (recipe.equals(brew.getRecipeName())) {
                        volume = volume + brew.getAllInVolume();
                    }
                }
                brewMapMonth.put(recipe,volume);
            }
            request.setAttribute("brewVolumeMapMonth", brewMapMonth);
            
            //Year List
            brewListYear = brewDB.getBrewByDateRange(previousYearDate, todaysDate);
            Set<String> currentRecipesYear = new HashSet<>();
            Map<String, Double> brewMapYear = new HashMap<>();
            
            for (Brew brew : brewListYear){
                currentRecipesYear.add(brew.getRecipeName());
            }
            
            for (String recipe : currentRecipesYear) {
                
                double volume = 0;
                
                for (Brew brew : brewListYear) {
                    
                    if (recipe.equals(brew.getRecipeName())) {
                        volume = volume + brew.getAllInVolume();
                    }
                }
                brewMapYear.put(recipe,volume);
            }
            request.setAttribute("brewVolumeMapYear", brewMapYear);
            
            //All Time List
            brewListAllTime = brewDB.getAll();
            Set<String> currentRecipesAllTime = new HashSet<>();
            Map<String, Double> brewMapAllTime = new HashMap<>();
            
            for (Brew brew : brewListAllTime){
                currentRecipesAllTime.add(brew.getRecipeName());
            }
            
            for (String recipe : currentRecipesAllTime) {
                
                double volume = 0;
                
                for (Brew brew : brewListAllTime) {
                    
                    if (recipe.equals(brew.getRecipeName())) {
                        volume = volume + brew.getAllInVolume();
                    }
                }
                brewMapAllTime.put(recipe,volume);
            }
            request.setAttribute("brewVolumeMapAllTime", brewMapAllTime);
            
        } catch (BrewDBException ex) {
            Logger.getLogger(ReportProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // ----------------------------- Total Volume by Brand Chart --------------------------- //
        
        
        // ------------------------------ Loss During Brewing Chart ------------------------------- //
        TransferDB transferDB = new TransferDB();
        List<Transfer> brewLossListWeek;
        List<Transfer> brewLossListMonth;
        List<Transfer> brewLossListYear;
        List<Transfer> brewLossListAllTime;
        try {
            //Week List
            brewLossListWeek = transferDB.getTransfersByDateRange(previousWeekDate, todaysDate);
            Set<String> currentTransferBrandWeek = new HashSet<>();
            Map<String, Double> transferMapWeek = new HashMap<>();
            
            for (Transfer transfer : brewLossListWeek){
                currentTransferBrandWeek.add(transfer.getBrand());
            }
            
            for (String transferBrand : currentTransferBrandWeek) {
                
                double volume = 0;
                
                for (Transfer transfer : brewLossListWeek) {
                    
                    if (transferBrand.equals(transfer.getBrand())) {
                        if (transfer.getCorrection() != null) {
                            volume = volume + transfer.getCorrection();
                        }
                    }
                }
                transferMapWeek.put(transferBrand,volume);
            }
            request.setAttribute("brewLossVolumeMapWeek", transferMapWeek);
            
            //Month List
            brewLossListMonth = transferDB.getTransfersByDateRange(previousMonthDate, todaysDate);
            Set<String> currentTransferBrandMonth = new HashSet<>();
            Map<String, Double> transferMapMonth = new HashMap<>();
            
            for (Transfer transfer : brewLossListMonth){
                currentTransferBrandMonth.add(transfer.getBrand());
            }
            
            for (String transferBrand : currentTransferBrandMonth) {
                
                double volume = 0;
                
                for (Transfer transfer : brewLossListMonth) {
                    
                    if (transferBrand.equals(transfer.getBrand())) {
                        if (transfer.getCorrection() != null) {
                            volume = volume + transfer.getCorrection();
                        }
                    }
                }
                transferMapMonth.put(transferBrand,volume);
            }
            request.setAttribute("brewLossVolumeMapMonth", transferMapMonth);
            
            //Year List
            brewLossListYear = transferDB.getTransfersByDateRange(previousYearDate, todaysDate);
            Set<String> currentTransferBrandYear = new HashSet<>();
            Map<String, Double> transferMapYear = new HashMap<>();
            
            for (Transfer transfer : brewLossListYear){
                currentTransferBrandYear.add(transfer.getBrand());
            }
            
            for (String transferBrand : currentTransferBrandYear) {
                
                double volume = 0;
                
                for (Transfer transfer : brewLossListYear) {
                    
                    if (transferBrand.equals(transfer.getBrand())) {
                        if (transfer.getCorrection() != null) {
                            volume = volume + transfer.getCorrection();
                        }
                    }
                }
                transferMapYear.put(transferBrand,volume);
            }
            request.setAttribute("brewLossVolumeMapYear", transferMapYear);
            
            //All Time List
            brewLossListAllTime = transferDB.getAllTransfer();
            Set<String> currentTransferBrandAllTime = new HashSet<>();
            Map<String, Double> transferMapAllTime = new HashMap<>();
            
            for (Transfer transfer : brewLossListAllTime){
                currentTransferBrandAllTime.add(transfer.getBrand());
            }
            
            for (String transferBrand : currentTransferBrandAllTime) {
                
                double volume = 0;
                
                for (Transfer transfer : brewLossListAllTime) {
                    
                    if (transferBrand.equals(transfer.getBrand())) {
                        if (transfer.getCorrection() != null) {
                            volume = volume + transfer.getCorrection();
                        }
                    }
                }
                transferMapAllTime.put(transferBrand,volume);
            }
            request.setAttribute("brewLossVolumeMapAllTime", transferMapAllTime);
            
        } catch (BrewDBException ex) {
            Logger.getLogger(ReportProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // ------------------------------ END Loss During Brewing Chart ------------------------------ //
        
        
        // ------------------------------ Loss During Production Chart ------------------------------- //
        //prodDB was created previously
        List<Production> prodLossWeek;
        List<Production> prodLossMonth;
        List<Production> prodLossYear;
        List<Production> prodLossAllTime;
        try {
            //Week List
            prodLossWeek = prodDB.getProdByDateRange(previousWeekDate, todaysDate);
            Set<String> currentProdTypeWeek = new HashSet<>();
            Map<String, Double> prodLossMapWeek = new HashMap<>();
            
            for (Production production : prodLossWeek){
                currentProdTypeWeek.add(production.getProductionType());
            }
            
            for (String prodType : currentProdTypeWeek) {
                
                double volume = 0;
                
                for (Production production : prodLossWeek) {
                    
                    if (prodType.equals(production.getProductionType())) {
                        if (production.getGainLoss() != 0) {
                            volume = volume + production.getGainLoss();
                        }
                    }
                }
                prodLossMapWeek.put(prodType,volume);
            }
            request.setAttribute("prodLossWeek", prodLossMapWeek);
            
            //Month List
            prodLossMonth = prodDB.getProdByDateRange(previousMonthDate, todaysDate);
            Set<String> currentProdTypeMonth = new HashSet<>();
            Map<String, Double> prodLossMapMonth = new HashMap<>();
            
            for (Production production : prodLossMonth){
                currentProdTypeMonth.add(production.getProductionType());
            }
            
            for (String prodType : currentProdTypeMonth) {
                
                double volume = 0;
                
                for (Production production : prodLossMonth) {
                    
                    if (prodType.equals(production.getProductionType())) {
                        if (production.getGainLoss() != 0) {
                            volume = volume + production.getGainLoss();
                        }
                    }
                }
                prodLossMapMonth.put(prodType,volume);
            }
            request.setAttribute("prodLossMonth", prodLossMapMonth);
            
            //Year List
            prodLossYear = prodDB.getProdByDateRange(previousYearDate, todaysDate);
            Set<String> currentProdTypeYear = new HashSet<>();
            Map<String, Double> prodLossMapYear = new HashMap<>();
            
            for (Production production : prodLossYear){
                currentProdTypeYear.add(production.getProductionType());
            }
            
            for (String prodType : currentProdTypeYear) {
                
                double volume = 0;
                
                for (Production production : prodLossYear) {
                    
                    if (prodType.equals(production.getProductionType())) {
                        if (production.getGainLoss() != 0) {
                            volume = volume + production.getGainLoss();
                        }
                    }
                }
                prodLossMapYear.put(prodType,volume);
            }
            request.setAttribute("prodLossYear", prodLossMapYear);
            
            //All Time List
            prodLossAllTime = prodDB.getAllProduction();
            Set<String> currentProdTypeAllTime = new HashSet<>();
            Map<String, Double> prodLossMapAllTime = new HashMap<>();
            
            for (Production production : prodLossAllTime){
                currentProdTypeAllTime.add(production.getProductionType());
            }
            
            for (String prodType : currentProdTypeAllTime) {
                
                double volume = 0;
                
                for (Production production : prodLossAllTime) {
                    
                    if (prodType.equals(production.getProductionType())) {
                        if (production.getGainLoss() != 0) {
                            volume = volume + production.getGainLoss();
                        }
                    }
                }
                prodLossMapAllTime.put(prodType,volume);
            }
            request.setAttribute("prodLossAllTime", prodLossMapAllTime);
            
            } catch (BrewDBException ex) {
            Logger.getLogger(ReportProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // ---------------------------- END Loss During Production CHART -----------------------
        
        getServletContext().getRequestDispatcher("/WEB-INF/reportsProduction.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method. This method is not used on the reports page.
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
