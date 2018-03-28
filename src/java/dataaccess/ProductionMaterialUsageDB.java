/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Productionmaterialusage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author reare
 */
public class ProductionMaterialUsageDB
{

    public int insert(Productionmaterialusage p) throws BrewDBException
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try
        {
            trans.begin();
            em.persist(p);
            trans.commit();
            return 1;
        } catch (Exception ex)
        {
            trans.rollback();
            Logger.getLogger(ProductionMaterialUsageDB.class.getName()).log(Level.SEVERE, "Cannot insert production", ex);
            throw new BrewDBException("Error inserting production material usage");
        } finally
        {
            em.close();
        }
    }

    public List<Productionmaterialusage> getAll() throws BrewDBException
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try
        {
            List<Productionmaterialusage> p = em.createNamedQuery("Productionmaterialusage.findAll", Productionmaterialusage.class).getResultList();
            return p;
        } catch (Exception ex)
        {
            Logger.getLogger(ProductionMaterialDB.class.getName()).log(Level.SEVERE, "Cannot read production", ex);
            throw new BrewDBException("Error getting production");
        } finally
        {
            em.close();
        }
    }
}
