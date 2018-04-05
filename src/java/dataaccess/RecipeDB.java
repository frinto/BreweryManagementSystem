package dataaccess;

import domainmodel.Recipe;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
/**
 * This class represents methods for interacting with the database with recipes.
 * @author 553817
 */
public class RecipeDB {

    /**
     * This method persists recipes to the database 
     * @param recipe the recipe to be added to database
     * @return 1 if addition was successful
     * @throws BrewDBException 
     */
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
    /**
     * Method to update an existing recipe in the database
     * @param recipe existing recipe to be updated
     * @return 1 if update is successful
     * @throws BrewDBException 
     */

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

    /**
     * Method to retrieve a list of all recipes in the database
     * @return list of existing recipes from database
     * @throws BrewDBException 
     */
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

    /**
     * Method to retrieve recipe by specific name
     * @param recipeName the name of recipe to be retrieved from database
     * @return the recipe object from database
     * @throws BrewDBException 
     */
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

    /**
     * Method to delete a recipe from the database
     * @param recipe object to be deleted
     * @return 1 if deletion successful
     * @throws BrewDBException 
     */
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


}
