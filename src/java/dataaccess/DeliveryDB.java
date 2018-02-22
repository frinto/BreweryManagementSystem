package dataaccess;

import dataaccess.BrewDBException;
import domainmodel.Delivery;
import domainmodel.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class DeliveryDB {

    public int insert(Delivery delivery) throws dataaccess.BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(delivery);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, "Cannot insert " + delivery.toString(), ex);
            throw new BrewDBException("Error inserting delivery");
        } finally {
            em.close();
        }
    }

    public int update(Delivery delivery) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(delivery);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, "Cannot update " + delivery.toString(), ex);
            throw new BrewDBException("Error updating delivery");
        } finally {
            em.close();
        }
    }

    public List<Delivery> getAll() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Delivery> deliverys = em.createNamedQuery("Delivery.findAll", Delivery.class).getResultList();
            return deliverys;
        } catch (Exception ex) {
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, "Cannot read deliverys", ex);
            throw new BrewDBException("Error getting deliverys");
        } finally {
            em.close();
        }
    }
            public List<Delivery> getByDeliveryId(String deliveryId) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query queryDeliveryById = em.createNamedQuery("Delivery.findByDeliveryId", Delivery.class);
            queryDeliveryById.setParameter("deliveryId", Integer.parseInt(deliveryId));
            List delivery = queryDeliveryById.getResultList();
            return delivery;
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, "Cannot read products", ex);
            throw new BrewDBException("Error getting products");
        } finally {
            em.close();
        }
    }

    public Delivery getDelivery(String deliveryNum) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Delivery delivery = em.find(Delivery.class, Integer.parseInt(deliveryNum));
            return delivery;
        } catch (Exception ex) {
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, "Cannot read Delivery", ex);
            throw new BrewDBException("Error getting delivery");
        } finally {
            em.close();
        }
    }

    public int delete(Delivery delivery) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(delivery));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, "Cannot delete " + delivery.toString(), ex);
            throw new BrewDBException("Error deleting delivery");
        } finally {
            em.close();
        }
    }

    //Leftover from NotesDB project, may be useful as future example
    
//    public List<User> getUsersByCompany(Company company) throws DeliveryDBException {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        
//        try {
//            List<User> users = em.createNamedQuery("User.findByCompany", User.class).setParameter("company", company).getResultList();
//            return users;
//        } catch (Exception ex) {
//            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
//            throw new DeliveryDBException("Error getting Users");
//        } finally {
//            em.close();
//        }
//    }

}
