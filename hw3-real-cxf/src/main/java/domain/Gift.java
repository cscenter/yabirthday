package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 29.03.2015.
 */
@Entity
@Table(name="GIFTS")
public class Gift {
    @Id @GeneratedValue @Column(name="GIFT_ID")
    private long id;

    private User owner;

    private int price;
    private String name;

    @OneToMany
    @JoinColumn(name="ACCOUNT_ID")
    private List<Account> investors_accs = new ArrayList<>();

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
