package com.ya.domain.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by olya on 11.05.15.
 */

@Entity
@Table(name="\"ACCOUNT_RECEIVER\"")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name="sourceId",
                referencedColumnName="id"),
        @PrimaryKeyJoinColumn(name="destinationId",
                referencedColumnName="id")
})
public class AccountReceiver implements Serializable {
    @Id
    private long sourceId;
    @Id
    private long destinationId;

    @ManyToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getsourceId() {
        return sourceId;
    }

    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
    }

    @ManyToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(long destinationId) {
        this.destinationId = destinationId;
    }

}