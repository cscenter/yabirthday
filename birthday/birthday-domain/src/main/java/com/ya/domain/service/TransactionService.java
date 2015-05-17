package com.ya.domain.service;

import com.ya.domain.model.Transaction;
import com.ya.domain.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TransactionService {
    @Inject
    TransactionRepository transactionRepository;

    public List<Transaction> listAccountTransactions(long id) {
        return transactionRepository.findByAccountId(id);
    }

}
