import org.eclipse.jetty.server.Server;

/**
 * Created by Rafa on 13.03.2015.
 */
public class Runner {
    public static void main(String[] args) throws Exception {
        System.out.printf("Hello wold");
        Server server = new Server(8080);
        server.setHandler(new JustHandler());

        server.start();
        server.join();
    }
}
