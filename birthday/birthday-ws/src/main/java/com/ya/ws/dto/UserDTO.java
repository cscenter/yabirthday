package com.ya.ws.dto;

import java.util.Calendar;

/**
 * Created by olya on 15.04.15.
 */
public class UserDTO {
    private final String login;
    private final Calendar birthday; //тип вроде надо заменить

    public UserDTO(String login, Calendar birthday) {
        this.login = login;
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public Calendar getBirthday() {
        return birthday;
    }
}
