package dataaccess;

import domainmodel.Brewmaterials;
import domainmodel.Productionmaterial;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Contains methods that allow inserting, accessing, updating, and deleting raw inventory data in the database.  
 */
public class RawInventoryDB {
    /**
     * Inserts a brew material into the database
     * @param brewMaterial type of brew material 
     * @return returns 1 if the insert is successful
     * @throws BrewDBException sends a message that there was an error inserting a brew material
     */
    public int insertInventoryBrewMaterial(Brewmaterials brewMaterial) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.persist(brewMaterial);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(TransferDB.class.getName()).log(Level.SEVERE, "Cannot insert " + brewMaterial.toString(), ex);
            throw new BrewDBException("Error inserting brewMaterial");
        } finally {
            em.close();
        }
    }
    /**
     * Retrieves a list of all brew materials
     * @return returns a list of all brew materials
     * @throws BrewDBException sends a message that there was an error retrieving the list of brew materials
     */
    public List<Brewmaterials> getAllInventoryBrewMaterial() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Brewmaterials> brewMaterials = em.createNamedQuery("Brewmaterials.findAll", Brewmaterials.class).getResultList();
            return brewMaterials;
        } catch (Exception ex) {
            Logger.getLogger(FinishedInventoryDB.class.getName()).log(Level.SEVERE, "Cannot read finished products", ex);
            throw new BrewDBException("Error getting finished product");
        } finally {
            em.close();
        }
    }

    /**
     * Updates a brew material
     * @param brewmaterial type of brew material
     * @return returns 1 if the update is successful
     * @throws BrewDBException sends a message that there was an error updating a brew material
     */
    public int updateBrewMaterials(Brewmaterials brewmaterial) throws BrewDBException
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(brewmaterial);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(RawInventoryDB.class.getName()).log(Level.SEVERE, "Cannot update ", ex);
            throw new BrewDBException("Error updating brewMaterials");
        } finally {
            em.close();
        }
    }
    
    //***********************PRODUCTION MATERIALS/////////////////////////////////////////////////
    /**
     * Inserts a production material into the database
     * @param productionMaterial type of production material 
     * @return returns 1 if the insert is successful
     * @throws BrewDBException sends a message that there was an error inserting a production material
     */
    public int insertInventoryProductionMaterial(Productionmaterial productionMaterial) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.persist(productionMaterial);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(TransferDB.class.getName()).log(Level.SEVERE, "Cannot insert " + productionMaterial.toString(), ex);
            throw new BrewDBException("Error inserting production material");
        } finally {
            em.close();
        }
    }
    /**
     * Retrieves a list of all production material
     * @return returns the list of all production material
     * @throws BrewDBException sends a message that there was an error retrieving a list of production material
     */
    public List<Productionmaterial> getAllInventoryProductionMaterial() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Productionmaterial> productionMaterials = em.createNamedQuery("Productionmaterial.findAll", Productionmaterial.class).getResultList();
            return productionMaterials;
        } catch (Exception ex) {
            Logger.getLogger(FinishedInventoryDB.class.getName()).log(Level.SEVERE, "Cannot read production materials", ex);
            throw new BrewDBException("Error getting production material");
        } finally {
            em.close();
        }
    }

    /**
     * Updates a production material in the database
     * @param productionmaterial type of production material
     * @return returns 1 if the update was successful
     * @throws BrewDBException sends a message that there was an error updating a production material
     */
    public int updateProductionMaterials(Productionmaterial productionmaterial) throws BrewDBException
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(productionmaterial);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(RawInventoryDB.class.getName()).log(Level.SEVERE, "Cannot update ", ex);
            throw new BrewDBException("Error updating production material");
        } finally {
            em.close();
        }
    }
    
    
}
