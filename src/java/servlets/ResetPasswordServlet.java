/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import businesslogic.EmployeeService;
import dataaccess.BrewDBException;
import dataaccess.EmployeeDB;
import domainmodel.Employee;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 727525
 */
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        if (uuid != null) {
            request.setAttribute("uuid", uuid);
            getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp").forward(request, response);
        }else{
        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uuid = UUID.randomUUID().toString();
        String link = request.getRequestURL().toString() + "?uuid=" + uuid;
        String email = request.getParameter("email");
        String action = request.getParameter("action");
        EmployeeService es = new EmployeeService();
        if (action.equals("email")) {
            
            if (email.isEmpty()) {
                request.setAttribute("message", "Email field empty");
                getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp/").forward(request, response);
            }
            
            String path = getServletContext().getRealPath("/WEB-INF");
            if (es.resetPassword(email, path, link, uuid) != null) {
//                HttpSession session = request.getSession();
//                session.setAttribute("uuid", uuid);
                request.setAttribute("message", "Email Sent!");
                getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Email does not exist");
                getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp/").forward(request, response);
            }
        } else if (action.equals("reset")) {
            String uuidNew = request.getParameter("uuid");
            String newPass = request.getParameter("password");
            Employee employee = new Employee();
            EmployeeDB ud = new EmployeeDB();
            try {
                employee = ud.getUuid(uuidNew);
            } catch (BrewDBException ex) {
                Logger.getLogger(ResetPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           //employee.setPassword(newPass);
            try {
                employee.setPassword(newPass);
                es.update(employee);
                request.setAttribute("message", "Password Reset!");
            } catch (Exception ex) {
                Logger.getLogger(ResetPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("message", "Problem reseting Password");
           }
           
           
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
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
