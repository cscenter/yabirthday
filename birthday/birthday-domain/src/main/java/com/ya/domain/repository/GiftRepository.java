package com.ya.domain.repository;

import com.ya.domain.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<Gift, String> {
}
