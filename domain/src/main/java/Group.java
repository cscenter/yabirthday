import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 24.03.2015.
 */
@Entity
@Table(name="GROUPS")
public class Group implements Serializable {
    @Id @GeneratedValue @Column(name = "NAME")
    private String name;

    @OneToMany
    @JoinColumn(name="USER_LOGIN")
    private List<User> users = new ArrayList<>();

    protected Group() { }

    public Group(String name) {
        this.name = name;
    }

    public void AddUser(User user) {
        users.add(user);
    }

    public ArrayList<User> GetUsers() {
        return new ArrayList<>(users);
    }

    public List<User> getUsers() {
        return users;
    }
}
