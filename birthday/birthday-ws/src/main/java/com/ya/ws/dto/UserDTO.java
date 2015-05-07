package com.ya.ws.dto;

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
