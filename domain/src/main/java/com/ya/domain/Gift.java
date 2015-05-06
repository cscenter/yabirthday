package com.ya.domain;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by MAX on 29.03.2015.
 */
@Entity
@Table(name="\"GIFT\"")
public class Gift {
    private long id;
    private User owner;
    private int price;
    private String name;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*@OneToMany
    @JoinColumn(name="ID")
    private List<Account> investorsAccs = new ArrayList<>();*/

    protected Gift() { }

    public Gift(User owner) {
        this.owner = owner;
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
        return false;
    }

    /*public List<Account> getInvestorsAccs() {
        return investorsAccs;
    }*/
}
