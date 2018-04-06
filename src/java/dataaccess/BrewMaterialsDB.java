package dataaccess;

import domainmodel.Brewmaterials;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class BrewMaterialsDB {
/**
 * Method to persist a brewing material to database
 * @param brewmaterial the brew material object to persist
 * @return 1 if the action was successful
 * @throws BrewDBException 
 */
    public int insert(Brewmaterials brewmaterial) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(brewmaterial);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(BrewMaterialsDB.class.getName()).log(Level.SEVERE, "Cannot insert " + brewmaterial.toString(), ex);
            throw new BrewDBException("Error inserting brewmaterial");
        } finally {
            em.close();
        }
    }
    /**
     * Method to update a brew material object 
     * @param brewmaterial the brew material to update
     * @return 1 if the update was successful
     * @throws BrewDBException 
     */

    public int update(Brewmaterials brewmaterial) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(brewmaterial);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(BrewMaterialsDB.class.getName()).log(Level.SEVERE, "Cannot update " + brewmaterial.toString(), ex);
            throw new BrewDBException("Error updating brewmaterial");
        } finally {
            em.close();
        }
    }
    /**
     * Method to get a list of all brew materials in the database
     * @return list of brew materials
     * @throws BrewDBException 
     */

    public List<Brewmaterials> getAll() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Brewmaterials> brewmaterials = em.createNamedQuery("brewmaterials.findAll", Brewmaterials.class).getResultList();
            return brewmaterials;
        } catch (Exception ex) {
            Logger.getLogger(BrewMaterialsDB.class.getName()).log(Level.SEVERE, "Cannot read materials", ex);
            throw new BrewDBException("Error getting brewmaterialss");
        } finally {
            em.close();
        }
    }
    /**
     * Method to specifically return a list of brew materials with a type of "hops"
     * @return list of hops
     * @throws BrewDBException 
     */
    
    public List<Brewmaterials> getHops() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query queryDeliveryById = em.createNamedQuery("Brewmaterials.findByType", Brewmaterials.class);
            queryDeliveryById.setParameter("type", "hops");
            List hops = queryDeliveryById.getResultList();
            return hops;
        } catch (Exception ex) {
            Logger.getLogger(BrewMaterialsDB.class.getName()).log(Level.SEVERE, "Cannot read materials", ex);
            throw new BrewDBException("Error getting brewmaterialss");
        } finally {
            em.close();
        }
    }
    /**
     * Method to return a list of brew materials of type "malt"
     * @return list of malt
     * @throws BrewDBException 
     */
    public List<Brewmaterials> getMalt() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query queryDeliveryById = em.createNamedQuery("Brewmaterials.findByType", Brewmaterials.class);
            queryDeliveryById.setParameter("type", "malt");
            List malt = queryDeliveryById.getResultList();
            return malt;
        } catch (Exception ex) {
            Logger.getLogger(BrewMaterialsDB.class.getName()).log(Level.SEVERE, "Cannot read materials", ex);
            throw new BrewDBException("Error getting brewmaterialss");
        } finally {
            em.close();
        }
    }
    /**
     * Method to return list of brew materials of type "chemical"
     * @return list of chemicals
     * @throws BrewDBException 
     */
    
    public List<Brewmaterials> getChemicals() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query queryDeliveryById = em.createNamedQuery("Brewmaterials.findByType", Brewmaterials.class);
            queryDeliveryById.setParameter("type", "chemical");
            List chemicals = queryDeliveryById.getResultList();
            return chemicals;
        } catch (Exception ex) {
            Logger.getLogger(BrewMaterialsDB.class.getName()).log(Level.SEVERE, "Cannot read materials", ex);
            throw new BrewDBException("Error getting brewmaterialss");
        } finally {
            em.close();
        }
    }

    /**
     * Get a single brew material by its name
     *
     * @param name name of brew material
     * @return a brew material object
     * @throws BrewDBException
     */
    public Brewmaterials getbrewmaterials(String name) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Brewmaterials brewmaterial = em.find(Brewmaterials.class, name);
            return brewmaterial;
        } catch (Exception ex) {
            Logger.getLogger(BrewMaterialsDB.class.getName()).log(Level.SEVERE, "Cannot read materials", ex);
            throw new BrewDBException("Error getting brewmaterials");
        } finally {
            em.close();
        }
    }


    
}
