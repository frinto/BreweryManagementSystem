/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.BrewDBException;
import dataaccess.EmployeeDB;
import domainmodel.Employee;
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

/**
 * this class contains the back end logic for managing employees, it contains
 * operations such as editing, adding and setting the employee as inactive
 * therefore doing a logical delete.
 * 
 * 
 * 
 * @author Huy Le
 */
@WebServlet(name = "ManageEmployeeServlet", urlPatterns = {"/ManageEmployeeServlet"})
public class ManageEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeDB employeeDB = new EmployeeDB();

        String action = request.getParameter("action");
        if (action != null && action.equals("viewEdit")) {
            String selectedUsername = request.getParameter("selectedUser");
            try {
                Employee employee = employeeDB.getEmployee(selectedUsername);

                request.setAttribute("selectedUser", employee);
            } catch (Exception ex) {
                Logger.getLogger(ManageEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (action != null && action.equals("viewAdd")) {
            String selectedUsername = request.getParameter("selectedUserAdd");
            try {
               
                request.setAttribute("selectedUserAdd", selectedUsername);
            } catch (Exception ex) {
                Logger.getLogger(ManageEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        List<Employee> users = null;
        try {
            users = employeeDB.getAll();
        } catch (Exception ex) {

        }

        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/manageEmployee.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeDB employeeDB = new EmployeeDB();

        String empId = request.getParameter("empId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String roleId = request.getParameter("roleId");
        String isActive = request.getParameter("isActive");
        String resetPasswordUUID = request.getParameter("resetPasswordUUID");

        String action = request.getParameter("action");

        if (action.equals("add")) {
            Employee employee = new Employee();

            employee.setEmail(email);
            employee.setFirstName(firstName);
            employee.setIsActive(Short.parseShort(isActive));
            employee.setLastName(lastName);
            employee.setPassword(password);
            employee.setResetPasswordUUID(resetPasswordUUID);
            employee.setRoleId(Integer.parseInt(roleId));

            try {
                employeeDB.insert(employee);
            } catch (BrewDBException ex) {
                Logger.getLogger(ManageEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (action.equals("edit")) {
            Employee employee = new Employee();

            employee.setEmpId(Integer.parseInt(empId));
            employee.setEmail(email);
            employee.setFirstName(firstName);
            employee.setIsActive(Short.parseShort(isActive));
            employee.setLastName(lastName);
            employee.setPassword(password);
            employee.setResetPasswordUUID(resetPasswordUUID);
            employee.setRoleId(Integer.parseInt(roleId));

            try {
                employeeDB.update(employee);
            } catch (BrewDBException ex) {
                Logger.getLogger(ManageEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        List<Employee> users = null;
        try {
            users = employeeDB.getAll();
        } catch (Exception ex) {

        }

        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/manageEmployee.jsp").forward(request, response);

    }

}
