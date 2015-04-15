import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 23.03.2015.
 */
@Entity
@Table(name="ACCOUNT")
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="ID")
    private long id;

    @OneToOne
    @JoinColumn(name="OWNER")
    private User owner;

    @OneToOne
    @JoinColumn(name="CASH")
    private Cash cash;

    @Column(name="FUNDS")
    private int funds;

    @OneToMany
    @JoinColumn(name="RECEIVERS")
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
