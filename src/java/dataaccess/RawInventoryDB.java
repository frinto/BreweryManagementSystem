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
 *
 * @author root
 */
public class RawInventoryDB {
    
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
