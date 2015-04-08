import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Rafa on 08.04.2015.
 */
public class JPAtest {

    private EntityManagerFactory factory = null;
    private EntityManager entityManager = null;

    private void init() {
        factory = Persistence.createEntityManagerFactory("persistence.xml");
        entityManager = factory.createEntityManager();
    }



    public static  void main(String args[]) {
        JPAtest jt = new JPAtest();
        jt.init();
    }

}
