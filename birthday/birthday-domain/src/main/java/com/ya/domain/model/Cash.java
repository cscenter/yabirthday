package com.ya.domain.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MAX on 23.03.2015.
 */
@Entity
@Table(name="\"CASH\"")
public class Cash implements Serializable {
    private long id;
    private User owner;
    //private Map<User, Account> accounts = new HashMap<>();

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
/*
    @OneToMany
    public Map<User, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<User, Account> accounts) {
        this.accounts = accounts;
    } */

    protected Cash() {}
    
    public Cash(User owner) {
        this.owner = owner;
    }
}
