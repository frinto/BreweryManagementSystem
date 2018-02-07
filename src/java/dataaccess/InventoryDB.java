/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.FinishedProduct;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author root
 */
public class InventoryDB {
    
    public int insertInventory(FinishedProduct finishedProduct) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(finishedProduct);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(TransferDB.class.getName()).log(Level.SEVERE, "Cannot insert " + finishedProduct.toString(), ex);
            throw new BrewDBException("Error inserting transfer");
        } finally {
            em.close();
        }
    }
    
    public List<FinishedProduct> getAllInventory() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<FinishedProduct> finishedProducts = em.createNamedQuery("FinishedProduct.findAll", FinishedProduct.class).getResultList();
            return finishedProducts;
        } catch (Exception ex) {
            Logger.getLogger(InventoryDB.class.getName()).log(Level.SEVERE, "Cannot read finished products", ex);
            throw new BrewDBException("Error getting finished product");
        } finally {
            em.close();
        }
    }
    
}