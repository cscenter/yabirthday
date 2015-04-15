import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 29.03.2015.
 */
@Entity
@Table(name="GIFT")
public class Gift {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)// @Column(name="GIFT_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name="LOGIN")
    private User owner;

    private int price;
    private String name;

    @OneToMany
    @JoinColumn(name="ID")
    private List<Account> investorsAccs = new ArrayList<>();

    protected Gift() { }

    public Gift(User owner) {
        //this.owner = owner;
        //investorsAccs = null;
    }

    public Gift(User owner, ArrayList<User> investors)
    {
        /*this.owner = owner;
        investorsAccs = new ArrayList<>();
        for (User investor : investors) {
            Account acc = investor.getAccountToDonate(owner);
            if (acc != null) {
                investorsAccs.add(acc);
            }
        }*/
    }

    public boolean IsSpecial()
    {
        //return investorsAccs != null;
        return true;
    }

    public List<Account> getInvestorsAccs() {
        //return investorsAccs;
        return null;
    }
}
