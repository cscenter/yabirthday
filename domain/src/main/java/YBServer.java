import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by MAX on 24.03.2015.
 */
public class YBServer {
    private DBConnector dbConnector;
    private ArrayList<Cash> cashList;
    //private HashMap<String, Cash> cashMap; //String - логин хозяина кассы

    public YBServer() {
        dbConnector = new DBConnector();
    }

    public void Init() throws SQLException {
        try (Connection conn = DriverManager.getConnection(makeUrl("birthday"), "db_name", "db_pswd")) {
            Statement st = conn.createStatement();

            //читаем БД, создаём объектное представление, запоминаем ссылки на кассы

            st.close();
            conn.close();
        }
    }

    private String makeUrl(String dbName) {
        return "jdbc:postgresql://localhost:5432/" + dbName;
    }
}
