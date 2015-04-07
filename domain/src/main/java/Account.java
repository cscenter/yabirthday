import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 23.03.2015.
 */
@Entity
@Table(name="ACCOUNTS")
public class Account {
    @Id @GeneratedValue @Column(name="ACCOUNT_ID")
    private long id;

    private User owner;
    private Cash cash;

    private int funds;

    @OneToMany
    @JoinColumn(name="USER_LOGIN")
    private List<User> receivers = new ArrayList<>();

    protected Account() { }

    public Account(User owner, Cash cash) {
        this.owner = owner;
        this.cash = cash;
    }

    public void addToReceivers(User user) {
        receivers.add(user);
    }

    public boolean isInCash(Cash cash) {
        return (this.cash == cash);
    }

    public List<User> getReceivers() {
        return receivers;
    }
}
