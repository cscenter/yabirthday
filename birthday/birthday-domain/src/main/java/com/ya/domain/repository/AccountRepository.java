package com.ya.domain.repository;

import com.ya.domain.model.Account;
import com.ya.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select u from Account u where owner_login = :login")
    public List<Account> listUserAccounts(@org.springframework.data.repository.query.Param("login") String login);
/*
    @Query("select u from list_user_fiends u")
    public List<Account> listFriendsAccounts();
    */
/*
    @Query("select account.id, account.funds, account.cash_id, account.owner_id " +
            "from User u inner join account on account.owner_login = u.login " +
            "inner join account_receiver on account.id = account_receiver.source_id " +
            "where u.login = :login")
    public List<Account> listFriendsAccounts(@org.springframework.data.repository.query.Param("login") String login);
*/
}
