package servlets;

import dataaccess.BrewDBException;
import dataaccess.EmployeeDB;
import domainmodel.Employee;
import java.io.IOException;
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
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        //Checks if the user is already logged in
        if (request.getAttribute("userId") != null) {
            try {
                String userId = (String) session.getAttribute("userId");
                EmployeeDB empDB = new EmployeeDB();
                Employee employee = empDB.getEmployee(userId);
                //If employee is inactive it is displayed by 0 and active is displayed by 1
                if (employee.getIsActive() == 0) {
                    request.setAttribute("loginMessage", "Account is inactive");
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    
                }
            } catch (BrewDBException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Checks the logout parameter if it is not null. If it is not null, 
        //the session will log the user out of the system.
        if (request.getParameter("logout") != null) {
                session = request.getSession();
                session.invalidate();
                request.setAttribute("loginMessage", "Logged out");
            }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            HttpSession session = request.getSession();
            EmployeeDB empDB = new EmployeeDB();
            
            String userId = request.getParameter("empId");
            String password = request.getParameter("password");
            
            // validatation for the user id and password
            if (userId == null || password == null || userId.isEmpty() || password.isEmpty()) {
                request.setAttribute("loginMessage", "Invalid.  Please try again.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
            //Gets the employee by the employee id and compares it to the password in the database.
            //If the employee id mataches the password then the employee will be logged in.
            Employee employee = empDB.getEmployee(userId);
            if (employee.getPassword().equals(password)) {
                session.setAttribute("empId", userId);
                response.sendRedirect("tankStatus");
            }
            //If the userId does not match the password, it will show that it was invalid and tell the user to try again
            else {
                request.setAttribute("loginMessage", "Invalid.  Please try again.");                    
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } catch (BrewDBException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
