import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by MAX on 23.03.2015.
 */
public class User {
    private String login;
    private Calendar birthday;
    private Cash cash;

    private ArrayList<Account> my_accs;
    private ArrayList<Account> investors_accs;

    private ArrayList<Gift> gifts_owned;

    public User(String login, Calendar birthday, Cash cash) {
        this.login = login;
        this.birthday = birthday;
        this.cash = cash;
    }

    public Account getAccountToDonate(User user) {
        Account res = null;
        for (Account acc : my_accs) {
            if (acc.isInCash(user.cash)) {
                res = acc;
            }
        }

        return res;
    }
}
