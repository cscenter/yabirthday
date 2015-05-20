package com.ya.domain.repository;

import com.ya.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User findByLogin(String login);

    @Query(value = "select * from \"user\" " +
            "where \"user\".login in (select account_friends.friends_login " +
            "from \"user\" join account on account.owner_login = \"user\".login " +
            "join account_friends on account.id = account_friends.account_id " +
            "where \"user\".login = :login )", nativeQuery = true)
    List<User> listUserFriends(@Param("login") String login);

    List<User> findByLoginContainingIgnoreCase(String part); //jpa magic!
}

