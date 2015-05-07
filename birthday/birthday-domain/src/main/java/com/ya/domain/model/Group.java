package com.ya.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 24.03.2015.
 */
@Entity
@Table(name="\"GROUP\"")
public class Group implements Serializable {
    private String name;
    private List<User> users = new ArrayList<>();

    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    protected Group() { }

    public Group(String name) {
        this.name = name;
    }

    public void AddUser(User user) {
        users.add(user);
    }
}
