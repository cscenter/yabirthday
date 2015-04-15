import org.hibernate.Session;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * Created by MAX on 24.03.2015.
 */
@RestController
@EnableAutoConfiguration
public class Main {
    public static void main(String[] args) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            System.out.print(session);

            User user = new User("userrrrr", Calendar.getInstance());
            User vasya = new User("vasya", Calendar.getInstance());

            Cash cash = new Cash(user);
            //user.setCash(cash);

            Group group = new Group("First_group");
            group.AddUser(user);
            group.AddUser(vasya);

            session.save(user);
            session.save(vasya);
            session.save(cash);
            session.save(group);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}
