import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by MAX on 23.03.2015.
 */
public class User {
    private Account MY_ACCOUNT;

    private String login;
    private Calendar birthday;
    private ArrayList<Account> receivers;

    public User(Account myAccount) {
        MY_ACCOUNT = myAccount;
    }

    public void AddReceiver(Account receiver) {
        receivers.add(receiver);
    }
}
