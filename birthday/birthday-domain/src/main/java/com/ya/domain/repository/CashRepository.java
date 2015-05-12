package com.ya.domain.repository;

import com.ya.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashRepository extends JpaRepository<Account, Long> {
}
