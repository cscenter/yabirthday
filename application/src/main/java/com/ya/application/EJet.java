package com.ya.application;

import com.ya.domain.*;
import org.hibernate.Session;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Calendar;


/**
 * Created by Max on 05.05.2015.
 */

@RestController
@EnableAutoConfiguration
public class EJet implements ServletContextListener {
    //Session session;

    public EJet() {
        //session = HibernateUtil.getSessionFactory().openSession();
    }

    @RequestMapping(value = "/{id}/*", method = RequestMethod.GET)
    String home3(@PathVariable(value = "id") Long id, @RequestParam(value="x", required=false, defaultValue="X3") String x) {
        return  "id = "+ id.toString() + "<br>x= " + x;
    }

    @RequestMapping("/")
    String home() {
        //return "ololos";

        String result = "Error";
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            User user = (User)session.get(User.class, "vasya");
            result = user.getLogin() + " and his Cash owner " + user.getCash().getOwner().getLogin();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

        //return result;
        return "ololos";
        
    }

    @RequestMapping("/write")
    String write() {
        String result = "Error";
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            User user = (User)session.get(User.class, "putin");

            if (user == null) {
                user = new User("putin");

                Cash cash = ((User)session.get(User.class, "vasya")).getCash();

                user.setCash(cash);
                user.setBirthday(Calendar.getInstance());

                Account user_acc = user.getCash().getOrCreateUserAccount(user);
                user_acc.setFunds(100500);

                session.save(user);
                session.save(user_acc);

                session.getTransaction().commit();

                result = "putin was added";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

        return result;
    }

    @RequestMapping("/check_write")
    String test() {
        String result = "Error";
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            User user = (User)session.get(User.class, "putin");

            if (user == null) {
                result = "no putin in db";
            } else {
                result = user.getLogin() + " and his Cash owner " + user.getCash().getOwner().getLogin();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("*** contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("*** contextDestroyed");
    }
}
