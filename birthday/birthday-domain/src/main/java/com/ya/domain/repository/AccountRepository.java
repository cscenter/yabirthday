package com.ya.domain.repository;

import com.ya.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    /*
    @Query("select u from Account u where owner_login = :login")
    public List<Account> listUserAccounts(@org.springframework.data.repository.query.Param("login") String login);
    */

    List<Account> findByOwnerLogin(String login);
}
