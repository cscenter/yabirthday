package com.ya.ws.dto;

import com.ya.domain.model.User;

import java.time.LocalDate;


/**
 * Created by olya on 15.04.15.
 */
public class UserDTO {
    private final String login;
    private final LocalDate birthday;
    private final GroupDTO group;

    public UserDTO(String login, LocalDate birthday, GroupDTO group) {
        this.login = login;
        this.birthday = birthday;
        this.group = group;
    }

    public UserDTO(User user) {
        this.login = user.getLogin();
        this.birthday = user.getBirthday();
        this.group = new GroupDTO(user.getGroup());
    }

    protected UserDTO() {
        birthday = null;
        login = null;
        group = null;
    }

    public String getLogin() {
        return login;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public GroupDTO getGroup() {return  group;}
}
