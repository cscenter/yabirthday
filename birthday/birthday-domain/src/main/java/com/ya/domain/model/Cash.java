package com.ya.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="\"CASH\"")
public class Cash implements Serializable {
    private long id;
    private User owner;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    protected Cash() {}
    
    public Cash(User owner) {
        this.owner = owner;
    }
}
