package com.ya.domain.service;

import com.ya.domain.model.Account;
import com.ya.domain.model.Transaction;
import com.ya.domain.model.User;
import com.ya.domain.repository.AccountRepository;
import com.ya.domain.repository.TransactionRepository;
import com.ya.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@Transactional
public class UserService {

    @Inject
    UserRepository userRepository;

    @Inject
    AccountRepository accountRepository;

    @Inject
    TransactionRepository transactionRepository;

    public List<User> list() {
        return userRepository.findAll();
    }

    public List<User> listPart(String part) {
        return userRepository.findByLoginContainingIgnoreCase(part);
    }

    public List<Transaction> listTransactions(String login) {
        List<Transaction> transactions = new ArrayList<Transaction>();
        List<Account> accounts = accountRepository.findByOwnerLogin(login);
        for (Account acc : accounts) {
            transactions.addAll(transactionRepository.findByAccountId(acc.getId()));
        }
        return transactions;
    }

    public Account addFriend(String login, String friendLogin) {
        List<Account> userAccs = accountRepository.findByOwnerLogin(login);

        User friend = userRepository.findOne(friendLogin);
        long cash = friend.getCash().getId();

        for (int acc = 0; acc < userAccs.size(); acc++) {
            if (userAccs.get(acc).getCash().getId() == cash) {
                Account account = userAccs.get(acc);
                accountRepository.findOne(account.getId())
                        .getFriends().add(userRepository.findByLogin(friendLogin));
                return accountRepository.save(account);
            }
        }

        Account account = new Account(userRepository.findOne(login), friend.getCash());
        accountRepository.save(account);
        accountRepository.findOne(account.getId()).getFriends().add(userRepository.findByLogin(friendLogin));
        return accountRepository.save(account);
    }

    public Account removeFriend(String login, String friendLogin) {
        long cash = userRepository.findOne(friendLogin).getCash().getId();
        List<Account> accounts = userRepository.findByLogin(login).getAccounts();
        Account acc = new Account();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getCash().getId() == cash) {
                acc = accounts.get(i);
                break;
            }
        }
        accountRepository.findOne(acc.getId()).getFriends().remove(userRepository.findOne(friendLogin));
        return accountRepository.save(acc);
    }

    public List<User> listUserFriends(String login) {
        return userRepository.listUserFriends(login);
    }

    public User create(String login, LocalDate birthday) {
        User user = new User(login);
        user.setBirthday(birthday);
        return userRepository.save(user);
    }

    public User update(String login, LocalDate birthday) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new NoSuchElementException("Not found user by login - " + login);
        }
        user.setBirthday(birthday);
        return userRepository.save(user);
    }

    public User get(String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new NoSuchElementException("Not found user by login - " + login);
        }
        return user;
    }

    public User remove(String login) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new NoSuchElementException("Not found user by login - " + login);
        }
        userRepository.delete(user);
        return user;
    }
}
