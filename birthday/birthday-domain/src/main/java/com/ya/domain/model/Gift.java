package com.ya.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private boolean owned;
    private List<Account> investors = new ArrayList<>();

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

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    @ManyToMany
    public List<Account> getInvestor() {
        return investors;
    }

    public void setInvestor(List<Account> investors) {
        this.investors = investors;
    }

    protected Gift() { }

    public Gift(User owner) {
        owned = false;
        this.owner = owner;
        //investorsAccs = null;
    }

    /*public Gift(User owner, ArrayList<User> investors) {
        this.owner = owner;
    }

    public boolean IsSpecial() {
        return false;
    }

    public void makeOwned() {
        owned = true;
        owner.addGift(this);
    } ;/

    /*public List<com.practice.yab.Account> getInvestorsAccs() {
        return investorsAccs;
    }*/
}
