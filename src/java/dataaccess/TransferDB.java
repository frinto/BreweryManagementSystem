package dataaccess;

import domainmodel.Transfer;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Class to manage insert transfers to the database and viewing them
 * @author Martin Czerwinski
 */
public class TransferDB {
    
    /**
     * insert a new Transfer record to the database
     * @param transfer The Transfer object to be inserted
     * @return integer 1 indicates success
     * @throws BrewDBException 
     */
    public int insertTransfer(Transfer transfer) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(transfer);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(TransferDB.class.getName()).log(Level.SEVERE, "Cannot insert " + transfer.toString(), ex);
            throw new BrewDBException("Error inserting transfer");
        } finally {
            em.close();
        }
    }
    
    /**
     * Retrieve a List of all the Transfer record objects in the database
     * @return a List of Transfer objects
     * @throws BrewDBException 
     */
    public List<Transfer> getAllTransfer() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Transfer> transfers = em.createNamedQuery("Transfer.findAll", Transfer.class).getResultList();
            return transfers;
        } catch (Exception ex) {
            Logger.getLogger(TransferDB.class.getName()).log(Level.SEVERE, "Cannot read transfers", ex);
            throw new BrewDBException("Error getting transfer");
        } finally {
            em.close();
        }
    }
    
    /**
     * Retrieves a List of Transfer record objects based on a specified date range
     * @param minDate the lowest date value to search for
     * @param maxDate the highest date value to search for
     * @return a List of Transfer objects
     * @throws BrewDBException 
     */
    public List<Transfer> getTransfersByDateRange (Date minDate, Date maxDate) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Transfer> transferList = em.createNamedQuery("Transfer.findByDateRange", Transfer.class)
                    .setParameter("minDate", minDate)
                    .setParameter("maxDate", maxDate)
                    .getResultList();
            return transferList;
        } catch (Exception ex) {
            Logger.getLogger(TransferDB.class.getName()).log(Level.SEVERE, "Cannot read transfers", ex);
            throw new BrewDBException("Error getting tranfer");
        } finally {
            em.close();
        }        
    }
}
