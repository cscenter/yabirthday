package com.ya.ws.dto;

import java.util.List;

/**
 * Created by olya on 15.04.15.
 */
public class UserPageDTO {
    private final UserDTO user;
    //private final CashDTO cash;
    private final List<AccountDTO> userAccs;
    private final List<TransactionDTO> transactions;
    private final List<UserDTO> friends;
    private final List<GiftDTO> gifts;
    private final long money;

    public UserPageDTO(UserDTO user, List<AccountDTO> userAccs, // CashDTO cash,
                       List<TransactionDTO> transactions, List<UserDTO> friends, List<GiftDTO> gifts, long money) {
        this.user = user;
        //this.cash = cash;
        this.userAccs = userAccs;
        this.transactions = transactions;
        this.friends = friends;
        this.gifts = gifts;
        this.money = money;
    }

    public UserDTO getUser() {
        return user;
    }

   // public CashDTO getCash() {return cash;}

    public List<TransactionDTO> getTransactions() {return transactions; }

    public List<UserDTO> getFriends() {return friends; }

    public List<AccountDTO> getUserAccs() {return userAccs;}

    public List<GiftDTO> getGifts() {return gifts;}

    public long getMoney() {return money;}
}
