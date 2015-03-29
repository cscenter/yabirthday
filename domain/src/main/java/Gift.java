import java.util.ArrayList;

/**
 * Created by MAX on 29.03.2015.
 */
public class Gift {
    private User OWNER;

    private int price;
    private String name;

    private ArrayList<User> investors;

    public Gift(User owner) {
        OWNER = owner;
        investors = null;
    }

    public Gift(User owner, ArrayList<User> investors)
    {
        OWNER = owner;
        this.investors = new ArrayList<>(investors);
    }

    public boolean IsSpecial()
    {
        return investors != null;
    }
}
