package dataaccess;

import domainmodel.Brew;
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

public class BrewDB {

    public int insert(Brew brew) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(brew);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Brew.class.getName()).log(Level.SEVERE, "Cannot insert " + brew.toString(), ex);
            throw new BrewDBException("Error inserting brew");
        } finally {
            em.close();
        }
    }

    public int update(Brew brew) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(brew);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Brew.class.getName()).log(Level.SEVERE, "Cannot update " + brew.toString(), ex);
            throw new BrewDBException("Error updating brew");
        } finally {
            em.close();
        }
    }

    public List<Brew> getAll() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Brew> brews = em.createNamedQuery("Brew.findAll", Brew.class).getResultList();
            return brews;
        } catch (Exception ex) {
            Logger.getLogger(Brew.class.getName()).log(Level.SEVERE, "Cannot read brews", ex);
            throw new BrewDBException("Error getting brews");
        } finally {
            em.close();
        }
    }

    public Brew getBrew(String brewNum) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Brew brew = em.find(Brew.class, Integer.parseInt(brewNum));
            return brew;
        } catch (Exception ex) {
            Logger.getLogger(Brew.class.getName()).log(Level.SEVERE, "Cannot read Brew", ex);
            throw new BrewDBException("Error getting brew");
        } finally {
            em.close();
        }
    }

    public int delete(Brew brew) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(brew));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Brew.class.getName()).log(Level.SEVERE, "Cannot delete " + brew.toString(), ex);
            throw new BrewDBException("Error deleting brew");
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

}
