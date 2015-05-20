package com.ya.ws.dto;

import com.ya.domain.model.Transaction;

import java.time.LocalDate;

/**
 * Created by olya on 09.05.15.
 */
public class TransactionDTO {
    private final long id;
    private final int sum;
    private final LocalDate date;
    private final AccountDTO account;
    private final GiftDTO destination;

    public TransactionDTO(long id, int sum, LocalDate date, AccountDTO account, GiftDTO destination) {
        this.id = id;
        this.sum = sum;
        this.date = date;
        this.account = account;
        this.destination = destination;
    }

    public TransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.sum = transaction.getSum();
        this.date = transaction.getDate();
        this.account = new AccountDTO(transaction.getAccount());
        if (transaction.getDestination() != null) {
            this.destination = new GiftDTO(transaction.getDestination());
        }
        else {
            this.destination = null;
        }
    }


    public long getId() {
        return  id;
    }

    public int getSum() {return  sum; }

    public LocalDate getDate() {return date; }

    public AccountDTO getAccount() {return account; }

    public GiftDTO getDestination() {return destination; }
}
