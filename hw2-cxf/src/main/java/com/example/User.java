package com.example;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;

@XmlRootElement(name = "User")
public class User {
    int id;
    String name;
    Date birthday;
    ArrayList friends;

    public User() {
        id = 42;
        name = new String("Super_hero");
        birthday = new Date(1993,11, 18); //устарела, да. Но нового не появилось
        friends = new ArrayList();
        friends.add(12);
        friends.add(14);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }
}