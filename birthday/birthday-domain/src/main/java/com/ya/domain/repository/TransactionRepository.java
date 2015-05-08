package com.ya.domain.repository;

import com.ya.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MAX on 08.05.2015.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
