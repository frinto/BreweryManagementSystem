/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Brewmaterials;
import domainmodel.Finishedproduct;
import domainmodel.Productionmaterial;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * this class represents all the operations for the database for 
 * raw inventory.
 * 
 * @author Huy Le
 */
public class RawInventoryDB {
    
    /**
     * this method inserts the brew material into the database
     * @param brewMaterial type Brewmaterials it represents the brew material
     * to be inserted
     * @return 1 if sucessfully inserted into the database.
     * @throws BrewDBException 
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
     * this method gets a list of all the brew materials in the database.
     * @return type List of brew materials in the database.
     * @throws BrewDBException 
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
     * this method update the specified brew materials.
     * @param brewmaterial type Brewmaterials it represents the brew material
     * to be updated.
     * @return 1 if the brew material was updated successfully.
     * @throws BrewDBException 
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
     * this method inserts production material into the database.
     * @param productionMaterial type Productionmaterial it represents
     * the production material to be inserted into the database.
     * @return 1 if successfully inserted into the database.
     * @throws BrewDBException 
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
     * gets a list of all production material in the database.
     * @return type List a list of all the production materials in the database.
     * @throws BrewDBException 
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
     * this method updates the specified production material in the database.
     * @param productionmaterial type Productionmaterial which represents
     * the production material to be updated.
     * @return 1 if the update was successful.
     * @throws BrewDBException 
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
