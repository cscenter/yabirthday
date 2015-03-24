import java.util.HashMap;

/**
 * Created by MAX on 23.03.2015.
 */
public class Account {
    private User OWNER;
    private Cash CASH;

    private HashMap<User, Integer> investorsFunds;

    public Account(User owner, Cash cash) {
        OWNER = owner;
        CASH = cash;
    }

    public void AddReceiver(User investor, int funds) {
        investorsFunds.put(investor, funds);
    }
    public void ChangeFunds(User investor, int diff) {
        Integer funds = investorsFunds.get(investor);
        if(funds != null) {
            funds += diff;
        }
    }
    public int GetFunds(User investor) {
        Integer funds = investorsFunds.get(investor);
        return funds != null ? funds : 0;
    }

    public User getOWNER() {
        return OWNER;
    }

    public Cash getCASH() {
        return CASH;
    }
}
