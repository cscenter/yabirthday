import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by MAX on 23.03.2015.
 */
@Entity
@Table(name="\"USER\"")
public class User implements Serializable {
    private String login;
    private Calendar birthday;
    private Cash cash;

    @Id @Column(name="\"LOGIN\"")
    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    @Column(name="\"BIRTHDAY\"")
    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "\"ID\"")
    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    @OneToMany
    @JoinColumn(name="\"ID\"")
    private List<Account> userAccs = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="\"ID\"")
    private List<Account> investorsAccs = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="\"ID\"")
    private List<Gift> giftsOwned = new ArrayList<>();

    protected User() { }

    public User(String login) {
        this.login = login;
    }

    public User(String login, Calendar birthday, Cash cash) {
        this.login = login;
        this.birthday = birthday;
        this.cash = cash;

        userAccs.add(cash.addAccountToUser(this));
    }

    public void addToInvestors(User user) {
        Account investor_acc = user.getAccountToDonate(this);//если кассы отличаются - провал
        investor_acc.addToReceivers(this);
        investorsAccs.add(investor_acc);
    }

    public Account getAccountToDonate(User user) {
        Account res = null;
        for (Account acc : userAccs) {
            if (acc.isInCash(user.cash)) {
                res = acc;
            }
        }

        return res;
    }

    /*public List<Account> getUserAccs() {
        return userAccs;
    }

    public List<Account> getInvestorsAccs() {
        return investorsAccs;
    }

    public List<Gift> getGiftsOwned() {
        return giftsOwned;
    }*/
}
