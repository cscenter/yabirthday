/**
 * Created by MAX on 14.03.2015.
 */
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Main extends AbstractHandler {

    private String getBirthdayList()
    {
        String res = "<h1>Birthdays:</h1><br>";

        DBConnector cn = new DBConnector();
        try {
            String list[] = cn.getBirthdayList();

            for(int i = 0; i != list.length; ++i) {
                res += list[i] + "<br>";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(getBirthdayList());
        baseRequest.setHandled(true);
    }

    public static void main(String[] args) throws Exception {
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8080);
        server.setHandler(new Main());
        server.start();
        server.join();
    }
}
