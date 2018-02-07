package dataaccess;

import domainmodel.Transfer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Martin Czerwinski
 */
public class TransferDB {
    
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
}
