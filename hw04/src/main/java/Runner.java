import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Rafa on 02.04.2015.
 */
public class Runner {

    public static void main(String args[]) {

        ConfigurableApplicationContext run = SpringApplication.run(Application.class);
        run.isRunning();
    }
}
