package businesslogic;

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

    public int logicalDelete(User user) throws NotesDBException
    {
        user.setActive(false);
        return employeeDB.update(user);
    }
    
    public List<User> getUsersByCompany(Company company) throws Exception {
        return employeeDB.getUsersByCompany(company);
    }
    
    public User resetPassword(String email, String path, String link, String uuid) {

        User user = null;

        UserDB userDB = new UserDB();
        try {
            user = userDB.getByEmail(email);
        } catch (NotesDBException ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        String username = null;
        username = user.getUsername();
        try {
            user = userDB.getUser(username);
        } catch (NotesDBException ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //WebMailService.sendMail(user.getEmail(), "NotesKeepr Logged in", "<h2>Congrats!  You just loggedin successfully.</h2>" , true);
            user.setResetPasswordUUID(uuid);
            userDB.update(user);

            HashMap<String, String> contents = new HashMap<>();

            contents.put("firstname", user.getFirstname());
            contents.put("lastname", user.getLastname());
            contents.put("username", user.getUsername());
            contents.put("link", link);

            String template = path + "/emailtemplates/resetpassword.html";
            WebMailService.sendMail(user.getEmail(), "NotesKeepr Reset", template, contents);

        } catch (Exception ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
