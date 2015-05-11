package com.ya.domain.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by olya on 11.05.15.
 */
@Entity
@Table(name="\"GIFT_INVESTOR\"")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name="giftId",
                referencedColumnName="gift.id"),
        @PrimaryKeyJoinColumn(name="accountId",
                referencedColumnName="account.id")
})
public class GiftInvestor implements Serializable {
    @Id
    private long giftId;
    @Id
    private long accountId;

    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getGiftId() {
        return giftId;
    }

    public void setGiftId(long giftId) {
        this.giftId = giftId;
    }

    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}