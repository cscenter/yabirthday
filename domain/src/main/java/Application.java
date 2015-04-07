import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by MAX on 07.04.2015.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    GroupRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        repository.save(new Group("First"));
        repository.save(new Group("Second"));
    }
}
