package com.ya.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by MAX on 23.03.2015.
 */
@Entity
@Table(name="\"USER\"")
public class User implements Serializable {
    private String login;
    private LocalDate birthday;
    private Cash cash;
    private List<Account> userAccs = new ArrayList<>();
    private List<Gift> giftsOwned = new ArrayList<>();

    @Id
    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
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
    public List<Account> getUserAccs() {
        return userAccs;
    }

    public void setUserAccs(List<Account> userAccs) {
        this.userAccs = userAccs;
    }

    @OneToMany
    public List<Gift> getGiftsOwned() {
        return giftsOwned;
    }

    public void setGiftsOwned(List<Gift> giftsOwned) {
        this.giftsOwned = giftsOwned;
    }

    protected User() { }

    public User(String login) {
        this.login = login;
    }

    public User(String login, Cash cash, LocalDate birthday) {
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

    public void addGift(Gift gift) {
        giftsOwned.add(gift);
    }

    private void addAccount(Account account) {
        userAccs.add(account);
    }
}
