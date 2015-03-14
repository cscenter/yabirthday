import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class MyHandler extends AbstractHandler {
    final ResultSet toWrite;

    public MyHandler(ResultSet a) {
        toWrite = a;
    }

    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();
        try {
            toWrite.first();
            out.println("<table border=\"1\"><tr><th>Login</th><th>Birthday</th></tr>");
            while (toWrite.next()) {
                out.println("<tr><td>" + toWrite.getString("login") + "</td><td>" + toWrite.getDate("birthday") + "</td></tr>");
            }
            out.println("</table>");
        }
        catch (SQLException e) {
            e.printStackTrace();
            out.println("<h1>Error with reading DataBase</h1>");
        }
        baseRequest.setHandled(true);
    }
}
