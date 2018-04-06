package dataaccess;

import domainmodel.Employee;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * This class deals with the database operations for employee.
 * 
 * @author Huy Le
 */
public class EmployeeDB {

    /**
     * This method inserts employee into the database.
     * 
     * @param employee type Employee it represents the employee to be inserted.
     * @return 1 if employee inserted sucessfully into database.
     * @throws BrewDBException 
     */
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

    /**
     * Update the specified employee in the database.
     * 
     * @param employee type Employee it represents the employee to be updated
     * @return 1 if the employee was successfully updated.
     * @throws BrewDBException 
     */
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

    /**
     * this method grabs all the employees in the database and returns a list
     * @return type List which contains a list of all employees in the database.
     * @throws BrewDBException 
     */
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

    /**
     * deletes the specified employee
     * @param employee type Employee it represents the employee to be deleted.
     * @return 1 if the employee was deleted sucessfully.
     * @throws BrewDBException 
     */
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

    /**
     * grabs the employee by a specified email
     * @param email type String it represents the email of the employee
     * @return type Employee of the employee with the specified email
     * @throws BrewDBException 
     */
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
    
    /**
     * gets the employee based on the uuid
     * @param resetPasswordUUID type String that represents the reset password
     * unique id of the employee.
     * @return type Employee of the employee with the specified reset password
     * uuid.
     * @throws BrewDBException 
     */
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
