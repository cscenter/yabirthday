import org.springframework.orm.jpa.support.JpaDaoSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


//import org.springframework.dao.support.DaoSupport;
/**
 * Created by Rafa on 08.04.2015.
 */
public class UserDAO extends JpaDaoSupport{

    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager manager = null;

    public UserDAO() {
        manager = getEntityManagerFactory().createEntityManager();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    void persist(User t){
// persist the object
        getManager().persist(t);
    }
    public void delete(User t){
// delete the row
        getManager().remove(t);
    }

    public EntityManager getManager() {
        return manager;
    }
}
