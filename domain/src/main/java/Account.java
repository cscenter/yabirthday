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

    public Account(User owner, Cash cash) {
        this.owner = owner;
        this.cash = cash;
    }

    public boolean isInCash(Cash cash) {
        return (this.cash == cash);
    }
}
