import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Rafa on 14.03.2015.
 */

public class JustHandler extends AbstractHandler {

    final static DataBase base = new DataBase();

    @Override
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException
    {

        base.connect();
        String query = request.getParameter("req");

        String header = "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                " <head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <title>money collecting</title>\n" +
                " </head>\n" +
                " <body>\n" +
                "<h2>LOL! it's work!</h2>";

        String result = "";
        if (query != null) result += base.getHTMLBySQL(query);
        String form = "<form action=\"localhost\" method=\"get\">\n" +
                "    <p><b>SQL request:\n</b>" +
                "    <input type=\"text\" size=\"40\" name=\"req\"  value=\"SELECT * FROM bithdays\" />" +
                "    <input type=\"submit\" value=\"GO\" />\n" +
                "  </form>";
        String footer = "<footer>\n" +
                "request was:" + query +
                "  </footer></body></html>";
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        String answer = header +result + form + footer;
        response.getWriter().println( answer );

    }
}
