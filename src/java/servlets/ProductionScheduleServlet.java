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
import java.util.Date;
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
            List<Productionschedule> productionSchedules = productionScheduleDatabase.getAll();

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

        ProductionScheduleDB productionScheduleDatabase = new ProductionScheduleDB();

        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("update")) {
                try {
                    List<Productionschedule> productionSchedules = productionScheduleDatabase.getAll();
                    String[] brewArr = new String[productionSchedules.size()];
                    String[] fvArr = new String[productionSchedules.size()];
                    String[] ystArr = new String[productionSchedules.size()];
                    String[] transferArr = new String[productionSchedules.size()];
                    String[] fugeArr = new String[productionSchedules.size()];
                    String[] cleanArr = new String[productionSchedules.size()];
                    String[] kegArr = new String[productionSchedules.size()];
                    String[] bottleArr = new String[productionSchedules.size()];
                    String[] canArr = new String[productionSchedules.size()];

                    String brewMon = request.getParameter("brewMon");
                    String brewTues = request.getParameter("brewTues");
                    String brewWed = request.getParameter("brewWed");
                    String brewThurs = request.getParameter("brewThurs");
                    String brewFri = request.getParameter("brewFri");

                    brewArr[0] = brewMon;
                    brewArr[1] = brewTues;
                    brewArr[2] = brewWed;
                    brewArr[3] = brewThurs;
                    brewArr[4] = brewFri;

                    String fvMon = request.getParameter("fvMon");
                    String fvTues = request.getParameter("fvTues");
                    String fvWed = request.getParameter("fvWed");
                    String fvThurs = request.getParameter("fvThurs");
                    String fvFri = request.getParameter("fvFri");

                    fvArr[0] = fvMon;
                    fvArr[1] = fvTues;
                    fvArr[2] = fvWed;
                    fvArr[3] = fvThurs;
                    fvArr[4] = fvFri;

                    String ystMon = request.getParameter("ystMon");
                    String ystTues = request.getParameter("ystTues");
                    String ystWed = request.getParameter("ystWed");
                    String ystThurs = request.getParameter("ystThurs");
                    String ystFri = request.getParameter("ystFri");

                    ystArr[0] = ystMon;
                    ystArr[1] = ystTues;
                    ystArr[2] = ystWed;
                    ystArr[3] = ystThurs;
                    ystArr[4] = ystFri;

                    String transferMon = request.getParameter("transferMon");
                    String transferTues = request.getParameter("transferTues");
                    String transferWed = request.getParameter("transferWed");
                    String transferThurs = request.getParameter("transferThurs");
                    String transferFri = request.getParameter("transferFri");

                    transferArr[0] = transferMon;
                    transferArr[1] = transferTues;
                    transferArr[2] = transferWed;
                    transferArr[3] = transferThurs;
                    transferArr[4] = transferFri;

                    String fugeMon = request.getParameter("fugeMon");
                    String fugeTues = request.getParameter("fugeTues");
                    String fugeWed = request.getParameter("fugeWed");
                    String fugeThurs = request.getParameter("fugeThurs");
                    String fugeFri = request.getParameter("fugeFri");

                    fugeArr[0] = fugeMon;
                    fugeArr[1] = fugeTues;
                    fugeArr[2] = fugeWed;
                    fugeArr[3] = fugeThurs;
                    fugeArr[4] = fugeFri;

                    String cleanMon = request.getParameter("cleanMon");
                    String cleanTues = request.getParameter("cleanTues");
                    String cleanWed = request.getParameter("cleanWed");
                    String cleanThurs = request.getParameter("cleanThurs");
                    String cleanFri = request.getParameter("cleanFri");

                    cleanArr[0] = cleanMon;
                    cleanArr[1] = cleanTues;
                    cleanArr[2] = cleanWed;
                    cleanArr[3] = cleanThurs;
                    cleanArr[4] = cleanFri;

                    String kegMon = request.getParameter("kegMon");
                    String kegTues = request.getParameter("kegTues");
                    String kegWed = request.getParameter("kegWed");
                    String kegThurs = request.getParameter("kegThurs");
                    String kegFri = request.getParameter("kegFri");

                    kegArr[0] = kegMon;
                    kegArr[1] = kegTues;
                    kegArr[2] = kegWed;
                    kegArr[3] = kegThurs;
                    kegArr[4] = kegFri;

                    String bottleMon = request.getParameter("bottleMon");
                    String bottleTues = request.getParameter("bottleTues");
                    String bottleWed = request.getParameter("bottleWed");
                    String bottleThurs = request.getParameter("bottleThurs");
                    String bottleFri = request.getParameter("bottleFri");

                    bottleArr[0] = bottleMon;
                    bottleArr[1] = bottleTues;
                    bottleArr[2] = bottleWed;
                    bottleArr[3] = bottleThurs;
                    bottleArr[4] = bottleFri;

                    String canMon = request.getParameter("canMon");
                    String canTues = request.getParameter("canTues");
                    String canWed = request.getParameter("canWed");
                    String canThurs = request.getParameter("canThurs");
                    String canFri = request.getParameter("canFri");

                    canArr[0] = canMon;
                    canArr[1] = canTues;
                    canArr[2] = canWed;
                    canArr[3] = canThurs;
                    canArr[4] = canFri;

                    for (int i = 0; i < productionSchedules.size(); i++) {
                        productionSchedules.get(i).setBrew(brewArr[i]);
                        productionSchedules.get(i).setFv(fvArr[i]);
                        productionSchedules.get(i).setYst(ystArr[i]);
                        productionSchedules.get(i).setTransfer(transferArr[i]);
                        productionSchedules.get(i).setFuge(fugeArr[i]);
                        productionSchedules.get(i).setClean(cleanArr[i]);
                        productionSchedules.get(i).setKeg(kegArr[i]);
                        productionSchedules.get(i).setBottle(bottleArr[i]);
                        productionSchedules.get(i).setCan(canArr[i]);
                        productionScheduleDatabase.update(productionSchedules.get(i));
                    }
                    request.setAttribute("productionSchedules", productionSchedules);

                } catch (BrewDBException ex) {
                    Logger.getLogger(FinishedInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("message", "error updating production schedule list from database");

                }

            }
            if (action.equals("clear")) {
                try {
                    List<Productionschedule> productionSchedules = productionScheduleDatabase.getAll();
                    String[] brewArr = new String[productionSchedules.size()];
                    String[] fvArr = new String[productionSchedules.size()];
                    String[] ystArr = new String[productionSchedules.size()];
                    String[] transferArr = new String[productionSchedules.size()];
                    String[] fugeArr = new String[productionSchedules.size()];
                    String[] cleanArr = new String[productionSchedules.size()];
                    String[] kegArr = new String[productionSchedules.size()];
                    String[] bottleArr = new String[productionSchedules.size()];
                    String[] canArr = new String[productionSchedules.size()];

                    String brewMon = "";
                    String brewTues = "";
                    String brewWed = "";
                    String brewThurs = "";
                    String brewFri = "";

                    brewArr[0] = brewMon;
                    brewArr[1] = brewTues;
                    brewArr[2] = brewWed;
                    brewArr[3] = brewThurs;
                    brewArr[4] = brewFri;

                    String fvMon = "";
                    String fvTues = "";
                    String fvWed = "";
                    String fvThurs = "";
                    String fvFri = "";

                    fvArr[0] = fvMon;
                    fvArr[1] = fvTues;
                    fvArr[2] = fvWed;
                    fvArr[3] = fvThurs;
                    fvArr[4] = fvFri;

                    String ystMon = "";
                    String ystTues = "";
                    String ystWed = "";
                    String ystThurs = "";
                    String ystFri = "";

                    ystArr[0] = ystMon;
                    ystArr[1] = ystTues;
                    ystArr[2] = ystWed;
                    ystArr[3] = ystThurs;
                    ystArr[4] = ystFri;

                    String transferMon = "";
                    String transferTues = "";
                    String transferWed = "";
                    String transferThurs = "";
                    String transferFri = "";

                    transferArr[0] = transferMon;
                    transferArr[1] = transferTues;
                    transferArr[2] = transferWed;
                    transferArr[3] = transferThurs;
                    transferArr[4] = transferFri;

                    String fugeMon = "";
                    String fugeTues = "";
                    String fugeWed = "";
                    String fugeThurs = "";
                    String fugeFri = "";

                    fugeArr[0] = fugeMon;
                    fugeArr[1] = fugeTues;
                    fugeArr[2] = fugeWed;
                    fugeArr[3] = fugeThurs;
                    fugeArr[4] = fugeFri;

                    String cleanMon = "";
                    String cleanTues = "";
                    String cleanWed = "";
                    String cleanThurs = "";
                    String cleanFri = "";

                    cleanArr[0] = cleanMon;
                    cleanArr[1] = cleanTues;
                    cleanArr[2] = cleanWed;
                    cleanArr[3] = cleanThurs;
                    cleanArr[4] = cleanFri;

                    String kegMon = "";
                    String kegTues = "";
                    String kegWed = "";
                    String kegThurs = "";
                    String kegFri = "";

                    kegArr[0] = kegMon;
                    kegArr[1] = kegTues;
                    kegArr[2] = kegWed;
                    kegArr[3] = kegThurs;
                    kegArr[4] = kegFri;

                    String bottleMon = "";
                    String bottleTues = "";
                    String bottleWed = "";
                    String bottleThurs = "";
                    String bottleFri = "";

                    bottleArr[0] = bottleMon;
                    bottleArr[1] = bottleTues;
                    bottleArr[2] = bottleWed;
                    bottleArr[3] = bottleThurs;
                    bottleArr[4] = bottleFri;

                    String canMon = "";
                    String canTues = "";
                    String canWed = "";
                    String canThurs = "";
                    String canFri = "";

                    canArr[0] = canMon;
                    canArr[1] = canTues;
                    canArr[2] = canWed;
                    canArr[3] = canThurs;
                    canArr[4] = canFri;

                    for (int i = 0; i < productionSchedules.size(); i++) {
                        productionSchedules.get(i).setBrew(brewArr[i]);
                        productionSchedules.get(i).setFv(fvArr[i]);
                        productionSchedules.get(i).setYst(ystArr[i]);
                        productionSchedules.get(i).setTransfer(transferArr[i]);
                        productionSchedules.get(i).setFuge(fugeArr[i]);
                        productionSchedules.get(i).setClean(cleanArr[i]);
                        productionSchedules.get(i).setKeg(kegArr[i]);
                        productionSchedules.get(i).setBottle(bottleArr[i]);
                        productionSchedules.get(i).setCan(canArr[i]);
                        productionScheduleDatabase.update(productionSchedules.get(i));
                    }
                    request.setAttribute("productionSchedules", productionSchedules);

                } catch (BrewDBException ex) {
                    Logger.getLogger(FinishedInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("message", "error clearing list from database");

                }
            }

        }
        getServletContext().getRequestDispatcher("/WEB-INF/productionSchedule.jsp").forward(request, response);
    }
}
