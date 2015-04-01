/**
 * Created by Rafa on 24.03.2015.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class EmbeddedJetty {
   //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
       return  "Hello " +  name;
   }


    @RequestMapping(value = "/{id}/*", method = RequestMethod.GET)
    String home3(@PathVariable(value = "id") Long id, @RequestParam(value="x", required=false, defaultValue="X3") String x) {
        return  "id = "+ id.toString() + "<br>x= " + x;
    }

    public static void main(String[] args) throws Exception {

       // SessionFactory s = HibernateUtil.getSessionFactory();
        //System.out.print(s.openSession());
        //System.out.print(s);
        //Session session = (Session) s.openSession();


        org.hibernate.classic.Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        System.out.print(session);
        //Add new Employee object
        User emp = new User();
        emp.setUserBirthday("03.04.1990");
        emp.setUserName("Putin");
        emp.setUserId(42);


        //Save the employee in database
        session.save(emp);

        //Commit the transaction
        session.getTransaction().commit();
        HibernateUtil.shutdown();

        SpringApplication.run(EmbeddedJetty.class, args);
    }
}
