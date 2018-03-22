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
 *
 * @author root
 */
@WebServlet(name = "ManageEmployeeServlet", urlPatterns = {"/ManageEmployeeServlet"})
public class ManageEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        HttpSession session = request.getSession();
//        User admin = (User) session.getAttribute("adminSession");
//
//        UserService us = new UserService();
//
        EmployeeDB employeeDB = new EmployeeDB();

        String action = request.getParameter("action");
        if (action != null && action.equals("view")) {
            String selectedUsername = request.getParameter("selectedUser");
            try {
                Employee employee = employeeDB.getEmployee(selectedUsername);

                request.setAttribute("selectedUser", employee);
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

//        if(action != null && action.equals("logout"))
//        {
//            session.invalidate();
//            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//            return;
//        }else if(action != null && action.equals("view"))
//        {
//            getServletContext().getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
//            return;
//        }
//        else if(action == null && admin != null)
//        {
//            getServletContext().getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
//            return;
//        }
//        else
//        {
//            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//            return;
//        }
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
//
//        UserService us = new UserService();
//
//        if (action.equals("add"))
//        {
//            if (username.equals("") || password.equals("") || email.equals("") || firstname.equals("") || lastname.equals("") || active.equals("") || active.equals("") || role.equals("") || company.equals(""))
//            {
//                request.setAttribute("errorMessage", "please fill in all fields");
//
//            } else
//            {
//                companyInt = Integer.parseInt(company);
//                roleInt = Integer.parseInt(role);
//                activeInt = Integer.parseInt(active);
//
//                if (activeInt == 1)
//                {
//                    activeBoolean = true;
//                } else if (activeInt == 0)
//                {
//                    activeBoolean = false;
//                }
//
//                try
//                {
//                    us.insert(username, password, email, activeBoolean, firstname, lastname, roleInt, companyInt);
//                } catch (Exception ex)
//                {
//                    Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//
//        } else if (action.equals("delete"))
//        {
//            String selectedUsername = request.getParameter("selectedUser");
//            
//            try
//            {
//                User user = us.get(selectedUsername);
//                Role userRole = user.getRole();
//                
//                if(userRole.getRoleID() == 1)
//                {
//                    request.setAttribute("errorDelete", "ERROR Admins cannot be deleted!");
//                }
//                else
//                {
//                    us.delete(selectedUsername);
//                }
//            } catch (Exception ex)
//            {
//                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        } else 
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
