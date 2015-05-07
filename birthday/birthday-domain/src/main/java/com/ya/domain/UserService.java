package com.ya.domain;

import com.ya.domain.model.User;
import com.ya.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Max on 07.05.2015.
 */

@Service
@Transactional
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<User> list() {
        return userRepository.findAll();
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
