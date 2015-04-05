import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by MAX on 23.03.2015.
 */
@Entity
@Table(name="USERS")
public class User {
    @Id @Column(name="USER_LOGIN")
    private String login;

    private Calendar birthday;
    private Cash cash;

    @OneToMany
    @JoinColumn(name="ACCOUNT_ID")
    private List<Account> userAccs = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="ACCOUNT_ID")
    private List<Account> investorsAccs = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="GIFT_ID")
    private List<Gift> giftsOwned = new ArrayList<>();

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

    public List<Account> getUserAccs() {
        return userAccs;
    }

    public List<Account> getInvestorsAccs() {
        return investorsAccs;
    }

    public List<Gift> getGiftsOwned() {
        return giftsOwned;
    }
}
