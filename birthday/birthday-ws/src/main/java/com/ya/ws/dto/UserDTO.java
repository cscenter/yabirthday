package com.ya.ws.dto;

import com.ya.domain.model.User;

import java.time.LocalDate;


/**
 * Created by olya on 15.04.15.
 */
public class UserDTO {
    private final String login;
    private final LocalDate birthday;

    public UserDTO(String login, LocalDate birthday) {
        this.login = login;
        this.birthday = birthday;
    }

    public UserDTO(User user) {
        this.login = user.getLogin();
        this.birthday = user.getBirthday();
    }

    protected UserDTO() {
        birthday = null;
        login = null;
    }

    public String getLogin() {
        return login;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
