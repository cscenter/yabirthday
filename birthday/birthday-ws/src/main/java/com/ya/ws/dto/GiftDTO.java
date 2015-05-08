package com.ya.ws.dto;

import com.ya.domain.model.Gift;

/**
 * Created by olya on 15.04.15.
 */
public class GiftDTO {
    private final long id;
    private final UserDTO owner;
    private final int price;
    private final String name;

    public GiftDTO(long id, UserDTO owner, int price, String name) {
        this.id = id;
        this.owner = owner;
        this.price = price;
        this.name = name;
    }

    public GiftDTO(Gift gift) {
        this.id = gift.getId();
        this.owner = new UserDTO(gift.getOwner());
        this.price = gift.getPrice();
        this.name = gift.getName();
    }


    public long getId() {
        return  id;
    }

    public UserDTO getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
