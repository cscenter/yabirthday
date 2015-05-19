package com.ya.ws.dto;

import com.ya.domain.model.Account;
import com.ya.domain.model.User;

import java.time.LocalDate;


/**
 * Created by olya on 15.04.15.
 */

public class UserDTO {
    private final String login;
    private final LocalDate birthday;
    private final GroupDTO group;

    @Override
    public boolean equals(Object obj) {
        return (this.login.compareTo(((UserDTO)obj).getLogin()) == 0);
    }

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

    private AccountDTO convert_account(Account account) {
        return new AccountDTO(account);
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
