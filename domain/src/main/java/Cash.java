import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 23.03.2015.
 */
@Entity
@Table(name="\"CASH\"")
public class Cash implements Serializable {
    private long id;
    private User owner;

    @Id @Column(name="\"ID\"") @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "\"LOGIN\"")*/
    @OneToOne(mappedBy = "cash" )
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    /*@OneToMany
    @JoinColumn(name="\"ACCOUNTS\"")
    private List<Account> accounts = new ArrayList<>();*/

    public Cash() {}
    
    public Cash(User owner) {
        this.owner = owner;
    }

    public Account addAccountToUser(User user) {
        Account res = new Account(user, this);
        //accounts.add(res);
        return res;
    }

    /*public List<Account> getAccounts() {
        return accounts;
    }*/
}
