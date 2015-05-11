package com.ya.ws.dto;

import com.ya.domain.model.Account;

/**
 * Created by olya on 15.04.15.
 */
public class AccountDTO {
    private final long id;
    private final UserDTO owner;
    private final CashDTO cash;
    private final long funds;

    public AccountDTO(long id, UserDTO owner, CashDTO cash, int funds) {
        this.id = id;
        this.owner = owner;
        this.cash = cash;
        this.funds = funds;
    }

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.owner = new UserDTO(account.getOwner());
        this.cash = new CashDTO(account.getCash());
        this.funds = account.getFunds();
    }



    public long getId() {
        return id;
    }

    public UserDTO getOwner() {
        return  owner;
    }

    public CashDTO getCash() {
        return cash;
    }

    public long getFunds() {
        return funds;
    }
}
