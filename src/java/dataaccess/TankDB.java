/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Employee;
import domainmodel.Fv;
import domainmodel.Sv;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 727525
 */
public class TankDB {

    public int insertFV(Fv fv) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(fv);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(TankDB.class.getName()).log(Level.SEVERE, "Cannot insert " + fv.toString(), ex);
            throw new BrewDBException("Error inserting fv");
        } finally {
            em.close();
        }
    }
    
    public int insertSV(Sv sv) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(sv);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(TankDB.class.getName()).log(Level.SEVERE, "Cannot insert " + sv.toString(), ex);
            throw new BrewDBException("Error inserting sv");
        } finally {
            em.close();
        }
    }
    
    public int updateFV(Fv fv) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(fv);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(TankDB.class.getName()).log(Level.SEVERE, "Cannot update " + fv.toString(), ex);
            throw new BrewDBException("Error updating fv");
        } finally {
            em.close();
        }
    }
    
    public int updateSV(Sv sv) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(sv);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(TankDB.class.getName()).log(Level.SEVERE, "Cannot update " + sv.toString(), ex);
            throw new BrewDBException("Error updating sv");
        } finally {
            em.close();
        }
    }

    public List<Fv> getAllFV() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Fv> fvs = em.createNamedQuery("Fv.findAll", Fv.class).getResultList();
            return fvs;
        } catch (Exception ex) {
            Logger.getLogger(TankDB.class.getName()).log(Level.SEVERE, "Cannot read fvs", ex);
            throw new BrewDBException("Error getting fvs");
        } finally {
            em.close();
        }
    }
    
    public List<Sv> getAllSV() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Sv> svs = em.createNamedQuery("Sv.findAll", Sv.class).getResultList();
            return svs;
        } catch (Exception ex) {
            Logger.getLogger(TankDB.class.getName()).log(Level.SEVERE, "Cannot read svs", ex);
            throw new BrewDBException("Error getting svs");
        } finally {
            em.close();
        }
    }
    
    public Fv getFV(String fvId) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Fv fv = em.find(Fv.class, fvId);
            return fv;
        } catch (Exception ex) {
            Logger.getLogger(TankDB.class.getName()).log(Level.SEVERE, "Cannot read fv", ex);
            throw new BrewDBException("Error getting fv");
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
