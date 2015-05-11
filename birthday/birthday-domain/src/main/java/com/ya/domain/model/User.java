package com.ya.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by MAX on 23.03.2015.
 */
@Entity
@Table(name="\"USER\"")
public class User implements Serializable {
    private String login;
    private LocalDate birthday;
    private Cash cash;
    //private List<Account> userAccs = new ArrayList<>();
    private Group group;

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
/*
    @OneToMany //тут тоже теперь нужен селект
    public List<Account> getUserAccs() {
        return userAccs;
    }

    public void setUserAccs(List<Account> userAccs) {
        this.userAccs = userAccs;
    }
*/
    @ManyToOne
    public Group getGroup() {return group;}

    public void setGroup(Group group) {this.group = group; }

    protected User() { }

    public User(String login) {
        this.login = login;
    }

    public User(String login, Cash cash, LocalDate birthday, Group group) {
        this.login = login;
        this.birthday = birthday;
        this.cash = cash;
        this.group = group;
        /*
        Account a = new Account(this, cash);
        if (!userAccs.contains(a)) {
            userAccs.add(a);
        } */
    }
/*
    public void addInvestor(User investor) {
        Account investor_account = cash.getOrCreateUserAccount(investor);
        investor_account.addReceiver(this);
        investor.addAccount(investor_account);
    }
*/
/*
    public List<User> listFriends() {
        //тут нужен селект!
        //select user.*
        //from user join account on account.user_id = user.user_id
        //join account_receiver on account.id = account_receiver.from
        //where user.user_id = current_user
        List<User> friends = new ArrayList<>();

        for (Account acc : userAccs) {
            friends.addAll(acc.getReceiver().stream().map(Account::getOwner).collect(Collectors.toList()));
        }

        return friends;
    } */
/*
    public List<Transaction> listTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        for (Account acc : userAccs) {
            transactions.addAll(acc.getTransactions());
        }
        return transactions;
    }
*/
    /*
    private void addAccount(Account account) {
        userAccs.add(account);
    }
    */
}
