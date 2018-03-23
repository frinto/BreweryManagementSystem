/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Productionmaterial;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author reare
 */
public class ProductionMaterialDB
{
    
    public int insert(Productionmaterial p) throws BrewDBException
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
            Logger.getLogger(ProductionMaterialDB.class.getName()).log(Level.SEVERE, "Cannot insert production", ex);
            throw new BrewDBException("Error inserting production material");
        } finally
        {
            em.close();
        }
    }

    public List<Productionmaterial> getAll() throws BrewDBException
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try
        {
            List<Productionmaterial> p = em.createNamedQuery("Productionmaterial.findAll", Productionmaterial.class).getResultList();
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
