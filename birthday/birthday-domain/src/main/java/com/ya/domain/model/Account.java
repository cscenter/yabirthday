package com.ya.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="\"ACCOUNT\"")
public class Account {
    private long id; 
    private User owner;
    private Cash cash;
    private long funds;
    private List<User> friends = new ArrayList<>();
/*
    public void addReceiver(Account account) {
        friends.add(account);
    } */
 
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() { 
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @ManyToOne
    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    public long getFunds() {
        return funds;
    }

    public void setFunds(long funds) {
        this.funds = funds;
    }

    @ManyToMany
    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> receivers) {
        this.friends = receivers;
    }
/*
    public void addTransaction(Transaction trans) {
        transactions.add(trans);
    } */


/*
    public List<Transaction> getTransactions() { //тут должен быть селект!!!
        //select * from transaction where account_id = this.id
        return new ArrayList<Transaction>();
    } */

    protected Account() { }

    public Account(User owner, Cash cash) {
        this.owner = owner;
        this.cash = cash;
    }

//    public void addReceiver(Account account) {
//        friends.add(account);
//    }

    public boolean isInCash(Cash cash) {
        return (this.cash == cash);
    }

    public void addFunds(int add) {
        funds += add;
    }
}
