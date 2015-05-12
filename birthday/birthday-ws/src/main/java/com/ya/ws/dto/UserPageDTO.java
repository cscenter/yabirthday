package com.ya.ws.dto;

import java.util.List;

/**
 * Created by olya on 15.04.15.
 */
public class UserPageDTO {
    private final UserDTO user;
    private final CashDTO cash;
    //private final List<AccountDTO> userAccs;
    private final List<TransactionDTO> transactions;
    //private final List<UserDTO> friends;

    public UserPageDTO(UserDTO user, CashDTO cash, List<TransactionDTO> transactions) {
        this.user = user;
        this.cash = cash;
        this.transactions = transactions;
    }
/*
    public UserPageDTO(UserDTO user, CashDTO cash, List<TransactionDTO> transactions, List<UserDTO> friends) {
        this.user = user;
        this.cash = cash;
        this.transactions = transactions;
        this.friends = friends;
    } */

/*
    public UserPageDTO(UserDTO user, CashDTO cash, List<AccountDTO> userAccs,
                       List<TransactionDTO> transactions, List<UserDTO> friends) {
        this.user = user;
        this.cash = cash;
        this.userAccs = userAccs;
        this.transactions = transactions;
        this.friends = friends;
    } */
/*
    public UserPageDTO(UserDTO user, CashDTO cash, List<AccountDTO> userAccs,
                       List<GiftDTO> giftsOwned, List<TransactionDTO> transactions, List<UserDTO> friends) {
        this.user = user;
        this.cash = cash;
        this.userAccs = userAccs;
        this.giftsOwned = giftsOwned;
        this.transactions = transactions;
        this.friends = friends;
    } */

    public UserDTO getUser() {
        return user;
    }

    public CashDTO getCash() {
        return cash;
    }

    public List<TransactionDTO> getTransactions() {return transactions; }

   // public List<UserDTO> getFriends() {return friends; }

/*
    public List<AccountDTO> getUserAccs() {
        return userAccs;
    }

    public List<TransactionDTO> getTransactions() {return transactions; }

    public List<UserDTO> getFriends() {return friends; } */
}
