package com.ya.domain.service;

import com.ya.domain.model.Account;
import com.ya.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by olya on 12.05.15.
 */

@Service
@Transactional
public class AccountService {
    @Inject
    AccountRepository accountRepository;

    public List<Account> listUserAccounts(String login) {
        return accountRepository.findByOwnerLogin(login);
    }
}
