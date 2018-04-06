package dataaccess;

import domainmodel.Brew;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BrewDB {

    /**
     * This method persists a brew object to the database
     * @param brew
     * @return brew that was inserted to database
     * @throws BrewDBException 
     */
    public Brew insert(Brew brew) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(brew);
            trans.commit();
            return brew;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Brew.class.getName()).log(Level.SEVERE, "Cannot insert " + brew.toString(), ex);
            throw new BrewDBException("Error inserting brew");
        } finally {
            em.close();
        }
    }

    /**
     * Updates an existing brew object from the database
     * @param brew
     * @return 1 if successful (for rows updated)
     * @throws BrewDBException 
     */
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
    /**
     * gets all brews from database and stores them in a list.
     * @return list of brews from database
     * @throws BrewDBException 
     */

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
    /**
     * Method to get a single brew by the brew number
     * @param brewNum the brew number of the specific brew to find
     * @return the brew matched to the brew number parameter
     * @throws BrewDBException 
     */

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

    /**
     * This method deletes a brew that has been passed into it from the database
     * @param brew the brew to be deleted
     * @return 1 if deletion was successful
     * @throws BrewDBException 
     */
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

    /**
     * Method to get a list of brews by a given date range
     * @param minDate min date selected
     * @param maxDate max date selected
     * @return list of brews between the two selected parameter dates
     * @throws BrewDBException 
     */
    public List<Brew> getBrewByDateRange(Date minDate, Date maxDate) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Brew> brewList = em.createNamedQuery("Brew.findByDateRange", Brew.class)
                    .setParameter("minDate", minDate)
                    .setParameter("maxDate", maxDate)
                    .getResultList();
            return brewList;
        } catch (Exception ex) {
            Logger.getLogger(BrewDB.class.getName()).log(Level.SEVERE, "Cannot read brew", ex);
            throw new BrewDBException("Error getting brew");
        } finally {
            em.close();
        }
    }
}
