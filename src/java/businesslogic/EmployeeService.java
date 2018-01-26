package businesslogic;

import dataaccess.BrewDBException;
import dataaccess.EmployeeDB;
import domainmodel.Role;
import domainmodel.Employee;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeService {

    private EmployeeDB employeeDB;

    public EmployeeService() {
        employeeDB = new EmployeeDB();
    }

    public Employee get(String empId) throws Exception {
        return employeeDB.getEmployee(empId);
    }

    public List<Employee> getAll() throws Exception {
        return employeeDB.getAll();
    }

    public int update(Employee employee) throws Exception {
        return employeeDB.update(employee);
    }

    public int delete(Employee employee) throws Exception {
        return employeeDB.delete(employee);
    }

    public int insert(Employee employee) throws Exception {
        return employeeDB.insert(employee);
    }

    public int logicalDelete(Employee employee) throws BrewDBException
    {
        employee.setIsActive((short)0);
        return employeeDB.update(employee);
    }
    
    
    
    public Employee resetPassword(String email, String path, String link, String uuid) {

        Employee employee = null;

        EmployeeDB employeeDB = new EmployeeDB();

        try {
            //WebMailService.sendMail(user.getEmail(), "NotesKeepr Logged in", "<h2>Congrats!  You just loggedin successfully.</h2>" , true);
            employee = employeeDB.getByEmail(email);
            employee.setResetPasswordUUID(uuid);
            employeeDB.update(employee);

            HashMap<String, String> contents = new HashMap<>();

            contents.put("firstname", employee.getFirstName());
            contents.put("lastname", employee.getLastName());
            contents.put("empId", employee.getEmpId().toString());
            contents.put("link", link);

            String template = path + "/emailtemplates/resetpassword.html";
            WebMailService.sendMail(employee.getEmail(), "Brewery Reset", template, contents);

        } catch (Exception ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return employee;
    }
}
