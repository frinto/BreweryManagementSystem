/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Production;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 579957
 */
public class ProductionDB {
    
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
