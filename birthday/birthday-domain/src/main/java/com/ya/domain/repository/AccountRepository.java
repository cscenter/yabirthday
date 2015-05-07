package com.ya.domain.repository;

import com.ya.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Max on 07.05.2015.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
