package dataaccess;

/**
 *
 * @author 553817
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Handles the creation of a singleton Entity Manager Factory. This ensures this is only ever one connection to the database at a time, so multiple users can work on the application.
 * @author 727525
 */
public class DBUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BreweryManagementSystemPU");

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
    public static void close() {
        emf.close();  // shut down factory
    }

}

