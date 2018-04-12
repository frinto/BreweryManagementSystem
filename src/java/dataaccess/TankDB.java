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
 * This class deals with persisting, deleting, retrieving and updating storage vessels and fermenting
 * vessels
 * @author Martin Czerwinski, Jesse Trieu, Huy Le
 */
public class TankDB {

    /**
     * Method to insert new fermenting vessel to database
     * @param fv fv object to be added
     * @return the fv object that has been added
     * @throws BrewDBException 
     */
    public Fv insertFV(Fv fv) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(fv);
            trans.commit();
            return fv;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(TankDB.class.getName()).log(Level.SEVERE, "Cannot insert " + fv.toString(), ex);
            throw new BrewDBException("Error inserting fv");
        } finally {
            em.close();
        }
    }
    /**
     * Method to insert storage vessel to database
     * @param sv sv object to store
     * @return sv object 
     * @throws BrewDBException 
     */
    
    public Sv insertSV(Sv sv) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(sv);
            trans.commit();
            return sv;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(TankDB.class.getName()).log(Level.SEVERE, "Cannot insert " + sv.toString(), ex);
            throw new BrewDBException("Error inserting sv");
        } finally {
            em.close();
        }
    }
    /**
     * update the fields of an FV Tank
     * @param fv the updated FV object
     * @return integer 1 indicates success
     * @throws BrewDBException 
     */
    
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
    
    /**
     * update the fields of SV Tank
     * @param sv the updated SV object
     * @return integer 1 indicates success
     * @throws BrewDBException 
     */
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
    
    /**
     * Retrieves all the FV Tank records from the database
     * @return a List of FV objects
     * @throws BrewDBException 
     */
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
    
    /**
     * Retrieves all the SV Tank records from the database
     * @return a List of SV objects
     * @throws BrewDBException 
     */
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
    
    /**
     * find an FV object by its primary key, FV ID
     * @param fvId the FV ID to search for
     * @return the corresponding FV object
     * @throws BrewDBException 
     */
    public Fv getFV(Integer fvId) throws BrewDBException {
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
    
    /**
     * find an SV object by its primary key, SV ID
     * @param svId the SV ID to search for
     * @return the corresponding SV object
     * @throws BrewDBException 
     */
    public Sv getSV(Integer svId) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Sv sv = em.find(Sv.class, svId);
            return sv;
        } catch (Exception ex) {
            Logger.getLogger(TankDB.class.getName()).log(Level.SEVERE, "Cannot read sv", ex);
            throw new BrewDBException("Error getting sv");
        } finally {
            em.close();
        }
    }
    
    /**
     * remove an FV object from the database
     * @param fv the FV object to be removed
     * @return integer 1 indicates success
     * @throws BrewDBException 
     */
    public int deleteFV(Fv fv) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(fv));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(TankDB.class.getName()).log(Level.SEVERE, "Cannot delete " + fv.toString(), ex);
            throw new BrewDBException("Error deleting fv");
        } finally {
            em.close();
        }
    }
    
    /**
     * remove an SV object from the database
     * @param sv the SV object to be removed
     * @return integer 1 indicates success
     * @throws BrewDBException 
     */
    public int deleteSV(Sv sv) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(sv));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(TankDB.class.getName()).log(Level.SEVERE, "Cannot delete " + sv.toString(), ex);
            throw new BrewDBException("Error deleting sv");
        } finally {
            em.close();
        }
    }
}
