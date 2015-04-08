/**
 * Created by Rafa on 02.04.2015.
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String userName;

    protected User() {}

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, userName='%s']",
                id, userName);
    }
}
