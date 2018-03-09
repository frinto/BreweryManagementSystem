/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.FinishedInventoryDB;
import dataaccess.ProductionDB;
import dataaccess.TankDB;
import domainmodel.Finishedproduct;
import domainmodel.Production;
import domainmodel.Sv;
import java.io.IOException;
import java.text.DecimalFormat;
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
        HttpSession session = request.getSession();
        TankDB tankDB = new TankDB();
        String startDateStr = request.getParameter("productionDate");

        if (startDateStr == null) {

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String startDate = sdf.format(new Date());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);

                session.setAttribute("productionDate", date);
            } catch (ParseException ex) {
                Logger.getLogger(ProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (startDateStr != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startDate = sdf.parse(startDateStr);
                session.setAttribute("productionDate", startDate);
            } catch (ParseException ex) {
                Logger.getLogger(ProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            ProductionDB prodDB = new ProductionDB();

            List<Production> prodList = prodDB.getAllProduction();

            List<Sv> svTankList = tankDB.getAllSV();

            request.setAttribute("prod", prodList);
            request.setAttribute("sv", svTankList);
            getServletContext().getRequestDispatcher("/WEB-INF/production.jsp").forward(request, response);
        } catch (BrewDBException ex) {
            Logger.getLogger(ProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String employeeId = (String) session.getAttribute("empId");
        String productionType = request.getParameter("productionType");
        String quantity = request.getParameter("quantity");
        String svNumber = request.getParameter("svNumber");
        String expectedSvVolume = request.getParameter("expectedSvVolume");
        String finishedSvVolume = request.getParameter("finishedSvVolume");
        Production production = new Production();
        ProductionDB prodDB = new ProductionDB();
        double volumePerUnit = 0;
        double currentVolume = 0;
        TankDB tankDB = new TankDB();
        FinishedInventoryDB finProdDB = new FinishedInventoryDB();
        DecimalFormat df = new DecimalFormat("#0.000");
        String success = "success";

        //navigates to the production form to submit a new production
        if (action.equals("add")) {
            try {
                List<Sv> svTankList = tankDB.getAllSV();
                List<Finishedproduct> finProdList = finProdDB.getAllInventory();

                request.setAttribute("finishedProd", finProdList);
                request.setAttribute("sv", svTankList);
                request.setAttribute("action", action);
                getServletContext().getRequestDispatcher("/WEB-INF/production.jsp").forward(request, response);
            } catch (BrewDBException ex) {
                Logger.getLogger(ProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equals("submitProduction")) {
            try {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String startDate = sdf.format(new Date());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
                double gainLoss = Double.parseDouble(df.format(Double.parseDouble(finishedSvVolume) - Double.parseDouble(expectedSvVolume)));

                production = new Production(production.getProdId(), Integer.parseInt(quantity), date, Integer.parseInt(employeeId), Integer.parseInt(svNumber), productionType, Double.parseDouble(df.format(Double.parseDouble(expectedSvVolume))), Double.parseDouble(finishedSvVolume), gainLoss);
                prodDB.insertProduction(production);

                List<Sv> svTankList = tankDB.getAllSV();

                List<Production> prodList = prodDB.getAllProduction();

                request.setAttribute("prod", prodList);
                request.setAttribute("sv", svTankList);
                request.setAttribute("success", success);
                getServletContext().getRequestDispatcher("/WEB-INF/production.jsp").forward(request, response);

            } catch (BrewDBException ex) {
                request.setAttribute("errorMessage", "Error has occured, please try again.");
                Logger.getLogger(ProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equals("nextProduction")) {
            try {
                List<Sv> svTankList = tankDB.getAllSV();
                List<Finishedproduct> finProdList = finProdDB.getAllInventory();

                for (int i = 0; i < svTankList.size(); i++) {
                    if (svTankList.get(i).getSvId() == Integer.parseInt(svNumber)) {
                        currentVolume = svTankList.get(i).getVolume();
                    }
                }

                List<Finishedproduct> finList = finProdDB.getAllInventory();
                for (int i = 0; i < finList.size(); i++) {
                    if (finList.get(i).getProductName().equals(productionType)) {
                        volumePerUnit = finList.get(i).getVolumePerUnit();
                    }
                }
                double totalProducedVolume = Double.parseDouble(quantity) * volumePerUnit;
                double expectedSvVolumeCalc = currentVolume - totalProducedVolume;
                if (expectedSvVolumeCalc < 0) {
                    request.setAttribute("errorMessage", "Expected sv volume cannot be less than zero.");
                    request.setAttribute("finishedProd", finProdList);
                    request.setAttribute("sv", svTankList);
                    request.setAttribute("action", "add");
                    getServletContext().getRequestDispatcher("/WEB-INF/production.jsp").forward(request, response);
                }
                request.setAttribute("expectedSvVolume", expectedSvVolumeCalc);
                request.setAttribute("productionType", productionType);
                request.setAttribute("quantity", quantity);
                request.setAttribute("svNumber", svNumber);

                request.setAttribute("action", action);

                getServletContext().getRequestDispatcher("/WEB-INF/production.jsp").forward(request, response);
            } catch (BrewDBException ex) {
                Logger.getLogger(ProductionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/production.jsp").forward(request, response);
        }
    }
}
