package com.ya.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by MAX on 23.03.2015.
 */
@Entity
@Table(name="\"USER\"")
public class User implements Serializable {
    private String login;
    private Calendar birthday;
    private Cash cash;
    private Set<Account> userAccs = new HashSet<>();

    @Id
    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @ManyToOne
    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    @OneToMany
    public Set<Account> getUserAccs() {
        return userAccs;
    }

    public void setUserAccs(Set<Account> userAccs) {
        this.userAccs = userAccs;
    }

    /*
    @OneToMany
    @JoinColumn(name="\"ID\"")
    private List<Gift> giftsOwned = new ArrayList<>();*/

    protected User() { }

    public User(String login) {
        this.login = login;
    }

    public User(String login, Cash cash, Calendar birthday) {
        this.login = login;
        this.birthday = birthday;
        this.cash = cash;

        userAccs.add(cash.getOrCreateUserAccount(this));
    }

    public void addInvestor(User investor) {
        Account investor_account = cash.getOrCreateUserAccount(investor);
        investor_account.addReceiver(this);
        investor.addAccount(investor_account);
    }

    private void addAccount(Account account) {
        userAccs.add(account);
    }

    /*
    public List<Gift> getGiftsOwned() {
        return giftsOwned;
    }*/
}
