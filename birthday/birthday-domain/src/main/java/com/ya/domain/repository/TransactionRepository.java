package com.ya.domain.repository;

import com.ya.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
/*
    @Query("select u from Transaction u where account_id = :id")
    public  List<Transaction> listAccountTransactions(@org.springframework.data.repository.query.Param("id") long id);
*/
    List<Transaction> findByAccountId(long id);
}
