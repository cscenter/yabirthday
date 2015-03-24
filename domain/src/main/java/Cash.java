import java.util.ArrayList;

/**
 * Created by MAX on 23.03.2015.
 */
public class Cash {
    private User OWNER;

    private ArrayList<Account> accounts;

    public Cash(User owner) {
        OWNER = owner;
    }

    public void AddAccount(Account account) {
        accounts.add(account);
    }
    public ArrayList<Account> GetAccounts() {
        return new ArrayList<>(accounts);
    }

    public void ChangeAccountFunds(String investor_login, int diff) {
    }

    public void ChangeAccountFunds(Account account, User investor, int diff) {
        account.ChangeFunds(investor, diff);
    }
}
