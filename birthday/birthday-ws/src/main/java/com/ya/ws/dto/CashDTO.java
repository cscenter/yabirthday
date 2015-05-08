package com.ya.ws.dto;

import com.ya.domain.model.Cash;

/**
 * Created by olya on 15.04.15.
 */
public class CashDTO {
    private final long id;
    private final UserDTO owner;

    public CashDTO(long id, UserDTO owner) {
        this.id = id;
        this.owner = owner;
    }

    public CashDTO(Cash cash) {
        this.id = cash.getId();
        this.owner = new UserDTO(cash.getOwner());
    }

    public long getId() {
        return id;
    }

    public UserDTO getOwner() {
        return owner;
    }
}
