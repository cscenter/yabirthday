import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;


public class Main {

    public static void main(String[] args) throws Exception
    {
      /*  Connection connection = null;
        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        String url = "jdbc:postgresql://127.0.0.1:5432/birthday_test1";
        //Имя пользователя БД
        String name = "postgres";
        //Пароль
        String password = "password";
        //Загружаем драйвер
        Class.forName("org.postgresql.Driver");
        //Создаём соединение
        connection = DriverManager.getConnection(url, name, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE); */

        Server server = new Server(8081);
        /*
        MyHandler handler = new MyHandler(statement);
        // MyServlet servlet = new MyServlet();
        server.setHandler(handler); */

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setWelcomeFiles(new String[]{ "index.html" });

        resource_handler.setResourceBase("/Users/olya/Documents/yabirthday/hw5-static-html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { resource_handler, new DefaultHandler() });
        server.setHandler(handlers);

       /* ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context); */

        //context.addServlet(new ServletHolder(new MyServlet("It works!")),"/*");

        server.start();
        server.join();
       // handler.close();
       // connection.close();
    }
}
