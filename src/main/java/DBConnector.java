import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by MAX on 14.03.2015.
 */
public class DBConnector {
    boolean valid;

    public DBConnector() {
        valid = true;
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
            valid = false;
        }
    }

    public ArrayList<String> getBirthdayList() throws SQLException {
        if(!valid) {
            return null;
        }

        ArrayList<String> rows = new ArrayList<String>();

        try (Connection conn = DriverManager.getConnection(makeUrl("birthday"), "postgres", "333")) {
            Statement st = conn.createStatement();

            String columns[] = new String[] { "login", "birthdate" };
            ResultSet response = selectColumnsFromTable(st, columns, "users");

            rows = new ArrayList<String>();
            while(response.next()) {
                rows.add(response.getString(2) + ": " + response.getString(3));
            }

            response.close();
            st.close();
            conn.close();
        }

        return rows;
    }

    private ResultSet selectColumnsFromTable(Statement st, String columns[], String table) throws SQLException {
        int length = columns.length;
        StringBuffer columnList;

        if(columns[0].equals("*")) {
            columnList = new StringBuffer("*");
        } else {
            columnList = new StringBuffer("\"" + columns[0] + "\"");

            if(length > 1) {
                for (String column : columns) {
                    columnList.append(", \"");
                    columnList.append(column);
                    columnList.append("\"");
                }
            }
        }

        return st.executeQuery("SELECT " + columnList.toString() + " FROM " + "\"" + table + "\"");
    }

    private String makeUrl(String dbName) {
        return "jdbc:postgresql://localhost:5432/" + dbName;
    }
}
