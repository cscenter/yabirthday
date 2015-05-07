package com.ya.ws.dto;

import java.util.List;

/**
 * Created by olya on 15.04.15.
 */
public class GroupDTO {
    private final String name;
    private final List<UserDTO> users;

    public GroupDTO(String name, List<UserDTO> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public List<UserDTO> getUsers() {
        return users;
    }
}
