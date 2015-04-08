import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rafa on 05.04.2015.
 */
public class JdbcPlainTest {
    private String DB_URL = "jdbc:postgresql://127.0.0.1:5432/birth"; // jdbc:postgresql://
    private final String USER_NAME = "postgres";
    private final String PASSWORD = "123";

    private Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
          conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        }
        catch (SQLException e) {
            System.err.print("Sad but true\n");
           e.printStackTrace();
        }
        return conn;
    }

    private  void query() {
        ResultSet rs = null;
        java.sql.Statement st = null;
        Connection conn = createConnection();

        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT  * FROM  birthdays");
            while (rs.next())
                System.out.println(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        JdbcPlainTest t = new JdbcPlainTest();
        t.query();

    }
}
