package com.ya.application;

import com.ya.domain.Account;
import com.ya.domain.Cash;
import com.ya.domain.User;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

/**
 * Created by olya on 06.05.15.
 */
@RestController
public class Controller {

    @RequestMapping(value = "/{id}/*", method = RequestMethod.GET)
    public String home3(@PathVariable(value = "id") Long id, @RequestParam(value="x", required=false, defaultValue="X3") String x) {
        return  "id = "+ id.toString() + "<br>x= " + x;
    }

    @RequestMapping("/")
    public String home() {

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

        return result;

    }

    @RequestMapping("/write")
    public String write() {
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
    public String test() {
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
}
