package com.ya.ws.dto;

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
