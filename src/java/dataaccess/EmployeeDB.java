package dataaccess;

import domainmodel.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EmployeeDB {

    public int insert(Employee employee) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(employee);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, "Cannot insert " + employee.toString(), ex);
            throw new BrewDBException("Error inserting employee");
        } finally {
            em.close();
        }
    }

    public int update(Employee employee) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(employee);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, "Cannot update " + employee.toString(), ex);
            throw new BrewDBException("Error updating employee");
        } finally {
            em.close();
        }
    }

    public List<Employee> getAll() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Employee> employees = em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
            return employees;
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            throw new BrewDBException("Error getting Employees");
        } finally {
            em.close();
        }
    }

    /**
     * Get a single user by their username.
     *
     * @param username The unique username.
     * @return A User object if found, null otherwise.
     * @throws NotesDBException
     */
    public Employee getEmployee(String empId) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Employee employee = em.find(Employee.class, Integer.parseInt(empId));
            return employee;
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            throw new BrewDBException("Error getting Employee");
        } finally {
            em.close();
        }
    }

    public int delete(Employee employee) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(employee));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, "Cannot delete " + employee.toString(), ex);
            throw new BrewDBException("Error deleting employee");
        } finally {
            em.close();
        }
    }

    //Leftover from NotesDB project, may be useful as future example
    
//    public List<User> getUsersByCompany(Company company) throws BrewDBException {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        
//        try {
//            List<User> users = em.createNamedQuery("User.findByCompany", User.class).setParameter("company", company).getResultList();
//            return users;
//        } catch (Exception ex) {
//            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
//            throw new BrewDBException("Error getting Users");
//        } finally {
//            em.close();
//        }
//    }
    
    public Employee getByEmail(String email) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Employee employee = em.createNamedQuery("Employee.findByEmail", Employee.class).setParameter("email", email).getSingleResult();
            return employee;
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            throw new BrewDBException("Error getting Employee");
        } finally {
            em.close();
        }
    }
    
    public Employee getUuid(String resetPasswordUUID) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Employee employee = em.createNamedQuery("Employee.findByResetPasswordUUID", Employee.class).setParameter("resetPasswordUUID", resetPasswordUUID).getSingleResult();
            return employee;
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            throw new BrewDBException("Error getting Employee");
        } finally {
            em.close();
        }
    }
}
