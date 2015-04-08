/**
 * Created by Rafa on 02.04.2015.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    UserRepository repository;


    @Override
    public void run(String... strings) throws Exception {
        // save a couple of customers
        repository.save(new User("Jack"));
        repository.save(new User("Chloe"));
        repository.save(new User("Kim"));
        repository.save(new User("David"));
        repository.save(new User("Michelle"));

        // fetch all customers
        System.out.println("User found with findAll():");
        System.out.println("-------------------------------");
        for (User customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer by ID
        User customer = repository.findOne(1L);
        System.out.println("User found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(customer);
        System.out.println();

        // fetch customers by last name
        System.out.println("User found with findByLastName('Bauer'):");
        System.out.println("--------------------------------------------");
        for (User bauer : repository.findByName("Bauer")) {
            System.out.println(bauer);
        }
    }

}
