/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Productionschedule;
import java.util.List;
import java.util.logging.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * this class deals with all the database operations for production schedule.
 * 
 * @author Huy Le
 */
public class ProductionScheduleDB {

    /**
     * gets a list of all the production schedule in the database.
     * @return type List a list of all the production material.
     * @throws BrewDBException 
     */
    public List<Productionschedule> getAll() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Productionschedule> productionSchedules = em.createNamedQuery("Productionschedule.findAll", Productionschedule.class).getResultList();
            return productionSchedules;
        } catch (Exception ex) {
            Logger.getLogger(FinishedInventoryDB.class.getName()).log(Level.SEVERE, "Cannot read production schedules", ex);
            throw new BrewDBException("Error getting finished product");
        } finally {
            em.close();
        }
    }
    
    /**
     * this method updates the production schedule in the database.
     * @param productionschedule type Productionschedule which represents
     * the production schedule to be updated.
     * @return 1 if the update was successful.
     * @throws BrewDBException 
     */
    public int update(Productionschedule productionschedule) throws BrewDBException
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(productionschedule);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(FinishedInventoryDB.class.getName()).log(Level.SEVERE, "Cannot update ", ex);
            throw new BrewDBException("Error updating production schedule");
        } finally {
            em.close();
        }
    }
    
}
