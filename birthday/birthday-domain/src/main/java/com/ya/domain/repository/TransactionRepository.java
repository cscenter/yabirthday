package com.ya.domain.repository;

import com.ya.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
/*
    @Query("select u from Transaction u where account_id =1")//where account_id = :id
    public  List<Transaction> lolListTransactions() ;

    @Query("select u from Transaction u")//where account_id = :id
    public  List<Transaction> lolListTransactions2();
*/

    @Query("select u from Transaction u where account_id = :id")
    public  List<Transaction> listAccountTransactions(@org.springframework.data.repository.query.Param("id") long id);


    //    @Query("select u from User u where u.login = :login")
//    User findByLogin(@Param("login") String login);
}
