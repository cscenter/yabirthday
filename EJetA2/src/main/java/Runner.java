import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Rafa on 26.04.2015.
 */
@ComponentScan(basePackages = "default")
@SpringBootApplication
public class Runner {
    public static void main(String[] args) {
        SpringApplication.run(EJet.class, args);
    }
/*
    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }
    */
}
