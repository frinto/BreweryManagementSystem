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

/**
 *
 * @author root
 */
public class ProductionScheduleDB {
    
        public List<Productionschedule> getAllInventory() throws BrewDBException {
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
    
}
