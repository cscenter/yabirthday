import java.sql.*;

/**
 * Created by Rafa on 13.03.2015.
 */
public class DataBase {
    private Connection connection = null;
    private String host = "127.0.0.1";
    private String port = "5432";
    private String dataBaseName = "bith";
    private String userName = "postgres";
    private String password = "123";

    public DataBase() {}
    public DataBase( String host, String port, String dataBaseName, String userName, String password) {
        this.host = host;
        this.port = port;
        this.dataBaseName = dataBaseName;
        this.userName = userName;
        this.password = password;
    }
    public void connect(){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;
        }


        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + host + ":" + port + "/" + dataBaseName, userName,
                    password);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

    }
    public String getHTMLBySQL(String sql) {
        String result = "<table>";
        try {
            System.out.println("Connection = " + connection.toString());
            PreparedStatement pst = connection.prepareStatement(sql);
            System.out.println("PST = " + pst.toString());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result += "<tr>";

                result +="<td>" + (rs.getString(1)) + "</td>";
                result +="<td>" + (rs.getString(2)) + "</td>";

                result += "</tr>";
            }
            result += "</table>";
            return  result;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("smth wrong");
            return null;
        }
    }
    public boolean getBySQL(String sql) {
        //sql = "SELECT * FROM bithdays"
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }
            return  true;
        } catch (Exception e){
            System.out.println("smth wrong");
            return false;
        }
    }
    public boolean setBySQL(String sql) {
        //String sql = "INSERT INTO bithdays VALUES ('RAFA', '03.04.1990')";
        java.sql.Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (Exception e){
            System.out.println("smth wrong");
            return false;
        }
    }
}
