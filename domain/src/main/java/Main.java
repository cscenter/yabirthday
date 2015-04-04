import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by MAX on 24.03.2015.
 */
public class Main extends AbstractHandler {
    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
    }

    public static void main(String[] args) throws Exception {
        YBServer srv = new YBServer();

        Cash cash = new Cash();
        User vasya = new User("vasya", Calendar.getInstance(), cash);
        User petya = new User("petya", Calendar.getInstance(), cash);
        User masha = new User("masha", Calendar.getInstance(), cash);

        vasya.addToInvestors(petya);
        petya.addToInvestors(masha);
        masha.addToInvestors(vasya);

        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8080);
        server.setHandler(new Main());
        server.start();
        server.join();
    }
}
