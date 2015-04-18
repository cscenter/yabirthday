import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Id @Column(name="\"ID\"") @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name="\"OWNER\"")
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @OneToOne
    @JoinColumn(name="\"CASH\"")
    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    @Column(name="\"FUNDS\"")
    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    /*@OneToMany
    @JoinColumn(name="RECEIVERS")
    private List<User> receivers = new ArrayList<>();*/

    protected Account() { }

    public Account(User owner, Cash cash) {
        this.owner = owner;
        this.cash = cash;
    }

    public void addToReceivers(User user) {
        //receivers.add(user);
    }

    public boolean isInCash(Cash cash) {
        return (this.cash == cash);
    }

    /*public List<User> getReceivers() {
        return receivers;
    }*/
}
