package domain;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 24.03.2015.
 */
public class Group {
    @Id
    private String name;

    @OneToMany
    @JoinColumn(name="USER_LOGIN")
    private List<User> users = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void AddUser(User user) {
        users.add(user);
    }

    public ArrayList<User> GetUsers() {
        return new ArrayList<>(users);
    }
}
