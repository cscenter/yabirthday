import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by MAX on 24.03.2015.
 */
public class DBConnector {
    boolean driverRegistered;

    public DBConnector() {
        driverRegistered = true;
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
            driverRegistered = false;
        }
    }


}
