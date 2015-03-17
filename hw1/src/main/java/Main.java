import org.eclipse.jetty.server.Server;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception
    {
        Connection connection = null;
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
                ResultSet.CONCUR_UPDATABLE);

        Server server = new Server(8081);
        MyHandler handler = new MyHandler(statement);
        server.setHandler(handler);
        server.start();
        server.join();
        handler.close();
        connection.close();
    }
}