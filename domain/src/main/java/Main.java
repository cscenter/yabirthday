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

            Cash cash = new Cash();

            User user = new User("userrrrr", Calendar.getInstance(), cash);
            cash.setOwner(user);

            Group group = new Group("First_group");
            group.AddUser(user);

            session.save(user);
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
