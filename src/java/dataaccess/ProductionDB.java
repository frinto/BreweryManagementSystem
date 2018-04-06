package dataaccess;

import domainmodel.Production;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Contains methods that allow inserting, accessing, updating, and deleting production data in the database.  
 * @author 579957
 */
public class ProductionDB {
    /**
     * Inserts a production into the database
     * @param p production that gets inserted
     * @return returns 1 if the insert was successful
     * @throws BrewDBException sends a message that there was an error inserting a production
     */
    public int insertProduction(Production p) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(p);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, "Cannot insert production", ex);
            throw new BrewDBException("Error inserting production");
        } finally {
            em.close();
        }
    }
    /**
     * Updates a production into the database
     * @param p production that gets updated
     * @return returns 1 if the update was successful
     * @throws BrewDBException sends a message that there was an error updating the production
     */
    public int updateProduction(Production p) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(p);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, "Cannot update production", ex);
            throw new BrewDBException("Error updating production");
        } finally {
            em.close();
        }
    }
    /**
     * Gets a list of all the productions in the database
     * @return returns a list of all productions
     * @throws BrewDBException sends a message that there was an error getting the list of productions
     */
    public List<Production> getAllProduction() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Production> p = em.createNamedQuery("Production.findAll", Production.class).getResultList();
            return p;
        } catch (Exception ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, "Cannot read production", ex);
            throw new BrewDBException("Error getting production");
        } finally {
            em.close();
        }
    }
    /**
     * Gets a production with a specified id
     * @param prodId the id of the production
     * @return returns the production with the same id
     * @throws BrewDBException sends a message that there was an error getting the production
     */
    public Production getProduction(Integer prodId) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Production p = em.find(Production.class, prodId);
            return p;
        } catch (Exception ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, "Cannot read production", ex);
            throw new BrewDBException("Error getting production");
        } finally {
            em.close();
        }
    }
    /**
     * Deletes a production from the database
     * @param p the production that will be deleted
     * @return returns 1 if the delete was successful
     * @throws BrewDBException sends a message that there was an error deleting the production
     */
    public int deleteProduction(Production p) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(p));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, "Cannot delete production", ex);
            throw new BrewDBException("Error deleting production");
        } finally {
            em.close();
        }
    }
    /**
     * Gets a list of productions within a certain range of dates
     * @param minDate the start date range for the list of productions
     * @param maxDate the end date range for the list of productions 
     * @return returns the list of productions within the date range
     * @throws BrewDBException sends a message that there was an error getting the list of productions
     */
    public List<Production> getProdByDateRange (Date minDate, Date maxDate) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Production> prodList = em.createNamedQuery("Production.findByDateRange", Production.class)
                    .setParameter("minDate", minDate)
                    .setParameter("maxDate", maxDate)
                    .getResultList();
            return prodList;
        } catch (Exception ex) {
            Logger.getLogger(ProductionDB.class.getName()).log(Level.SEVERE, "Cannot read production", ex);
            throw new BrewDBException("Error getting production");
        } finally {
            em.close();
        }        
    }
}
