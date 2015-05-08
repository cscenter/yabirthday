package com.ya.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by MAX on 08.05.2015.
 */
@Entity
@Table(name="\"TRANSACTION\"")
public class Transaction implements Serializable {
    private long id;
    private int sum;
    private LocalDate date;
    private Account account;
    private Gift destination;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @OneToOne
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @OneToOne
    public Gift getDestination() {
        return destination;
    }

    public void setDestination(Gift destination) {
        this.destination = destination;
    }

    protected Transaction() { }

    public Transaction(int sum, LocalDate date, Account account) {
        this.sum = sum;
        this.date = date;
        this.account = account;

        account.addFunds(sum);
    }

    public Transaction(int sum, LocalDate date, Account account, Gift destination) {
        this.sum = -sum;
        this.date = date;
        this.account = account;
        this.destination = destination;

        account.addFunds(-sum);
    }
}
