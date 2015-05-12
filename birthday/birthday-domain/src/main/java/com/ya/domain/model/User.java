package com.ya.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="\"USER\"")
public class User implements Serializable {
    private String login;
    private LocalDate birthday;
    private Cash cash;
    private Group group;

    @Id
    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @ManyToOne
    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    @ManyToOne
    public Group getGroup() {return group;}

    public void setGroup(Group group) {this.group = group; }

    protected User() { }

    public User(String login) {
        this.login = login;
    }

    public User(String login, Cash cash, LocalDate birthday, Group group) {
        this.login = login;
        this.birthday = birthday;
        this.cash = cash;
        this.group = group;
    }
}
