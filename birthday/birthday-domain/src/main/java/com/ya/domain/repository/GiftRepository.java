package com.ya.domain.repository;

import com.ya.domain.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GiftRepository extends JpaRepository<Gift, String> {

    List<Gift> findByOwnerLogin(String login);
}
