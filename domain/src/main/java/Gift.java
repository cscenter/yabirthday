import java.util.ArrayList;

/**
 * Created by MAX on 29.03.2015.
 */
public class Gift {
    private User owner;

    private int price;
    private String name;

    private ArrayList<Account> investors_accs;

    public Gift(User owner) {
        this.owner = owner;
        investors_accs = null;
    }

    public Gift(User owner, ArrayList<User> investors)
    {
        this.owner = owner;
        investors_accs = new ArrayList<>();
        for (User investor : investors) {
            Account acc = investor.getAccountToDonate(owner);
            if (acc != null) {
                investors_accs.add(acc);
            }
        }
    }

    public boolean IsSpecial()
    {
        return investors_accs != null;
    }
}
