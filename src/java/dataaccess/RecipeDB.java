package dataaccess;

import domainmodel.Recipe;
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

public class RecipeDB {

    public int insert(Recipe recipe) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(recipe);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Recipe.class.getName()).log(Level.SEVERE, "Cannot insert " + recipe.toString(), ex);
            throw new BrewDBException("Error inserting recipe");
        } finally {
            em.close();
        }
    }

    public int update(Recipe recipe) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(recipe);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Recipe.class.getName()).log(Level.SEVERE, "Cannot update " + recipe.toString(), ex);
            throw new BrewDBException("Error updating recipe");
        } finally {
            em.close();
        }
    }

    public List<Recipe> getAll() throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Recipe> recipes = em.createNamedQuery("Recipe.findAll", Recipe.class).getResultList();
            return recipes;
        } catch (Exception ex) {
            Logger.getLogger(Recipe.class.getName()).log(Level.SEVERE, "Cannot read recipes", ex);
            throw new BrewDBException("Error getting recipes");
        } finally {
            em.close();
        }
    }

    public Recipe getRecipe(String recipeName) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Recipe recipe = em.find(Recipe.class, recipeName);
            return recipe;
        } catch (Exception ex) {
            Logger.getLogger(Recipe.class.getName()).log(Level.SEVERE, "Cannot read Recipe", ex);
            throw new BrewDBException("Error getting recipe");
        } finally {
            em.close();
        }
    }

    public int delete(Recipe recipe) throws BrewDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(recipe));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(Recipe.class.getName()).log(Level.SEVERE, "Cannot delete " + recipe.toString(), ex);
            throw new BrewDBException("Error deleting recipe");
        } finally {
            em.close();
        }
    }

    //Leftover from NotesDB project, may be useful as future example
    
//    public List<User> getUsersByCompany(Company company) throws RecipeDBException {
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        
//        try {
//            List<User> users = em.createNamedQuery("User.findByCompany", User.class).setParameter("company", company).getResultList();
//            return users;
//        } catch (Exception ex) {
//            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
//            throw new RecipeDBException("Error getting Users");
//        } finally {
//            em.close();
//        }
//    }

}
