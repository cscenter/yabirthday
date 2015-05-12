package com.ya.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="\"GROUP\"")
public class Group implements Serializable {
    private long id;
    private String name;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {return  id;}

    public void setId(long id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Group() { }

    public Group(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
