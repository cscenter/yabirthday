import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by MAX on 23.03.2015.
 */
@Entity
@Table(name="\"ACCOUNT\"")
public class Account {
    private long id;
    private User owner;
    private Cash cash;
    private int funds;
    private Set<User> receiver = new HashSet<>();

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @OneToOne
    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    @OneToMany
    public Set<User> getReceiver() {
        return receiver;
    }

    public void setReceiver(Set<User> receivers) {
        this.receiver = receivers;
    }

    protected Account() { }

    public Account(User owner, Cash cash) {
        this.owner = owner;
        this.cash = cash;
    }

    public void addReceiver(User user) {
        receiver.add(user);
    }

    public boolean isInCash(Cash cash) {
        return (this.cash == cash);
    }
}
