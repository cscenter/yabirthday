package com.ya.ws.dto;

/**
 * Created by olya on 15.04.15.
 */
public class AccountDTO {
    private final long id;
    private final UserDTO owner;
    private final CashDTO cash;
    private final int funds;

    public AccountDTO(long id, UserDTO owner, CashDTO cash, int funds) {
        this.id = id;
        this.owner = owner;
        this.cash = cash;
        this.funds = funds;
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

    public int getFunds() {
        return funds;
    }
}
