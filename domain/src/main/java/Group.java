import
import java.util.ArrayList;

/**
 * Created by MAX on 24.03.2015.
 */
public class Group {
    private String NAME;

    private ArrayList<User> users;

    public Group(String name) {
        this.NAME = name;
    }

    public void AddUser(User user) {
        users.add(user);
    }

    public ArrayList<User> GetUsers() {
        return new ArrayList<>(users);
    }
}
