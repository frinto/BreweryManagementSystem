/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Finishedproduct;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * this class deals with the database operations for finishedInventory
 * 
 * @author Huy Le
 */
public class FinishedInventoryDB {

    /**
     * this method inserts a finished product into the database.
     * 
     * @param finishedProduct type Finishedproduct it is the product
     * to be inserted into the database.
     * @return 1 if the finished product was inserted successfully.
     * @throws BrewDBException 
     */
    public int insertInventory(Finishedproduct finishedProduct) throws BrewDBException {
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
            throw new BrewDBException("Error inserting finished product");
        } finally {
            em.close();
        }
    }

    /**
     * this method grabs a list of all the finished inventory in the database.
     * @return type List which represents a list of all the finished product.
     * @throws BrewDBException 
     */
    public List<Finishedproduct> getAllInventory() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Finishedproduct> finishedProducts = em.createNamedQuery("Finishedproduct.findAll", Finishedproduct.class).getResultList();
            return finishedProducts;
        } catch (Exception ex) {
            Logger.getLogger(FinishedInventoryDB.class.getName()).log(Level.SEVERE, "Cannot read finished products", ex);
            throw new BrewDBException("Error getting finished product");
        } finally {
            em.close();
        }
    }

    /**
     * this method updates the specified finished product.
     * @param finishedproduct type Finishedproduct it is the finished product
     * to be updated.
     * @return 1 if it was updated successfully.
     * @throws BrewDBException 
     */
    public int update(Finishedproduct finishedproduct) throws BrewDBException
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(finishedproduct);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(FinishedInventoryDB.class.getName()).log(Level.SEVERE, "Cannot update ", ex);
            throw new BrewDBException("Error updating finished product");
        } finally {
            em.close();
        }
    }
}
