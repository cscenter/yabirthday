import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;

public class SimplestServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);
        HandlerCollection handler = new HandlerCollection();
        handler.addHandler(new HelloHandler1());
        handler.addHandler(new HelloHandler());
        server.setHandler(handler);
        server.start();
        server.join();
    }
}