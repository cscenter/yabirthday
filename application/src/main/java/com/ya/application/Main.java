package com.ya.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MAX on 24.03.2015.
 */
@RestController
@EnableAutoConfiguration
//@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {

        /*
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            System.out.print(session);

            User user = new User("userrrrr");

            Cash cash = new Cash(user);

            user.setCash(cash);
            user.setBirthday(Calendar.getInstance());

            User vasya = new User("vasya", cash, Calendar.getInstance());

            Gift gift = new Gift(user);
            gift.setName("book");
            gift.setPrice(100500);

            Account vasya_acc = vasya.getCash().getOrCreateUserAccount(vasya);
            Account user_acc = user.getCash().getOrCreateUserAccount(user);

            vasya.addInvestor(user);

            Group group = new Group("First_group");
            group.AddUser(user);
            group.AddUser(vasya);

            session.save(user);
            session.save(vasya);
            session.save(cash);
            session.save(group);
            session.save(gift);
            session.save(vasya_acc);
            session.save(user_acc);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
        */
        SpringApplication.run(EJet.class, args);
    }
}
