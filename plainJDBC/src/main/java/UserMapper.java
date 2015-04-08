//import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rafa on 08.04.2015.
 */
public class UserMapper    implements RowMapper<User> {


    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User u = new User();
        u.setName(rs.getString("name"));
        return u;
    }
}
