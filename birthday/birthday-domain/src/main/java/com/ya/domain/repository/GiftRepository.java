package com.ya.domain.repository;

import com.ya.domain.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GiftRepository extends JpaRepository<Gift, String> {
    /*
    @Query("select u from Gift u where owner_login = :login")
    public List<Gift> listUserGifts(@org.springframework.data.repository.query.Param("login") String login);
    */

    List<Gift> findByOwner_login(String login);
}
