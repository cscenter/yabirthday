//package  org.banda.application.main;
//package main;

import Model.User;
import main.HibernateUtil;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
class Main {
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
        User user = new User();

        Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
        System.out.print(session);
        //Add new Employee object
        User emp = new User();
       // Date dd = Date.from(Instant.now());
       // emp.setUserBirthday(dd);
        //  emp.setUserName("Putin");
        emp.setUserId(42);
        session.save(emp);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
/**/
        SpringApplication.run(Main.class, args);
    }
}