package com.ya.ws.dto;

import com.ya.domain.model.Group;

/**
 * Created by olya on 15.04.15.
 */
public class GroupDTO {
    private final long id;
    private final String name;
    public GroupDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GroupDTO(Group group) {
        this.id = group.getId();
        this.name = group.getName();
    }

    public long getId() {return id;}

    public String getName() {return name;}
}
