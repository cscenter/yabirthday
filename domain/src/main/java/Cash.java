import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 23.03.2015.
 */
@Entity
@Table(name="CASHES")
public class Cash {
    @Id @GeneratedValue @Column(name="CASHES_ID")
    private long id;

    private User owner;

    @OneToMany
    @JoinColumn(name="ACCOUNT_ID")
    private List<Account> accounts = new ArrayList<>();

    public Cash() {}
    public Cash(User owner) {
        this.owner = owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Account addAccountToUser(User user) {
        Account res = new Account(user, this);
        accounts.add(res);
        return res;
    }
}
