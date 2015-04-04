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
    private List<Account> user_accs = new ArrayList<>();
    @OneToMany
    @JoinColumn(name="ACCOUNT_ID")
    private List<Account> investors_accs = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="GIFT_ID")
    private List<Gift> gifts_owned = new ArrayList<>();

    public User(String login, Calendar birthday, Cash cash) {
        this.login = login;
        this.birthday = birthday;
        this.cash = cash;

        user_accs.add(cash.addAccountToUser(this));
    }

    public void addToInvestors(User user) {
        Account investor_acc = user.getAccountToDonate(this);//если кассы отличаются - провал
        investor_acc.addToReceivers(this);
        investors_accs.add(investor_acc);
    }

    public Account getAccountToDonate(User user) {
        Account res = null;
        for (Account acc : user_accs) {
            if (acc.isInCash(user.cash)) {
                res = acc;
            }
        }

        return res;
    }
}
