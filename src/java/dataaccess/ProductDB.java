package dataaccess;

import dataaccess.BrewDBException;
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

public class ProductDB {

    public int insert(Product product) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(product);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, "Cannot insert " + product.toString(), ex);
            throw new BrewDBException("Error inserting product");
        } finally {
            em.close();
        }
    }

    public int update(Product product) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(product);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, "Cannot update " + product.toString(), ex);
            throw new BrewDBException("Error updating product");
        } finally {
            em.close();
        }
    }

    public List<Product> getAll() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Product> products = em.createNamedQuery("Product.findAll", Product.class).getResultList();
            return products;
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, "Cannot read products", ex);
            throw new BrewDBException("Error getting products");
        } finally {
            em.close();
        }
    }
    
        public List<Product> getByDeliveryId(String deliveryId) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query queryProductById = em.createNamedQuery("Product.findByDeliveryId", Product.class);
            queryProductById.setParameter("deliveryId", Integer.parseInt(deliveryId));
            List<Product> products = queryProductById.getResultList();
            return products;
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, "Cannot read products", ex);
            throw new BrewDBException("Error getting products");
        } finally {
            em.close();
        }
    }


    public int delete(Product product) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(product));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, "Cannot delete " + product.toString(), ex);
            throw new BrewDBException("Error deleting product");
        } finally {
            em.close();
        }
    }

    //Leftover from NotesDB project, may be useful as future example
    
//    public List<User> getUsersByCompany(Company company) throws ProductDBException {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        
//        try {
//            List<User> users = em.createNamedQuery("User.findByCompany", User.class).setParameter("company", company).getResultList();
//            return users;
//        } catch (Exception ex) {
//            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
//            throw new ProductDBException("Error getting Users");
//        } finally {
//            em.close();
//        }
//    }

}
