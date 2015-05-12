package com.ya.domain.repository;

import com.ya.domain.model.Account;
import com.ya.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("select u from Account u where owner_login = :login")
    public List<Account> listUserAccounts(@org.springframework.data.repository.query.Param("login") String login);
}
