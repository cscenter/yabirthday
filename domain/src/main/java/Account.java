import java.util.ArrayList;

/**
 * Created by MAX on 23.03.2015.
 */
public class Account {
    private User owner;
    private Cash cash;

    private int funds;

    private ArrayList<User> receivers;

    public Account(User owner, Cash cash) {
        this.owner = owner;
        this.cash = cash;
    }

    public boolean isInCash(Cash cash) {
        return (this.cash == cash);
    }
}
