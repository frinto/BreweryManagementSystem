package dataaccess;

import dataaccess.BrewDBException;
import domainmodel.Account;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class AccountDB {

    public int insert(Account account) throws dataaccess.BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(account);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, "Cannot insert " + account.toString(), ex);
            throw new BrewDBException("Error inserting account");
        } finally {
            em.close();
        }
    }

    public int update(Account account) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(account);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, "Cannot update " + account.toString(), ex);
            throw new BrewDBException("Error updating account");
        } finally {
            em.close();
        }
    }

    public List<Account> getAll() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Account> accounts = em.createNamedQuery("Account.findAll", Account.class).getResultList();
            return accounts;
        } catch (Exception ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, "Cannot read accounts", ex);
            throw new BrewDBException("Error getting accounts");
        } finally {
            em.close();
        }
    }

    public int delete(Account account) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(account));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, "Cannot delete " + account.toString(), ex);
            throw new BrewDBException("Error deleting account");
        } finally {
            em.close();
        }
    }

    //Leftover from NotesDB project, may be useful as future example
    
//    public List<User> getUsersByCompany(Company company) throws AccountDBException {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        
//        try {
//            List<User> users = em.createNamedQuery("User.findByCompany", User.class).setParameter("company", company).getResultList();
//            return users;
//        } catch (Exception ex) {
//            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
//            throw new AccountDBException("Error getting Users");
//        } finally {
//            em.close();
//        }
//    }

}
