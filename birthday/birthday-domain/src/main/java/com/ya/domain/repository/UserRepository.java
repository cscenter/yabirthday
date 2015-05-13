package com.ya.domain.repository;

import com.ya.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User findByLogin(String login);

    @Query(value = "select \"user\".login, \"user\".birthday, \"user\".cash_id, \"user\".group_id from " +
            "( select * from \"user\" join account on account.owner_login = \"user\".login " +
            "join account_receiver on account.id = account_receiver.source_id " +
            "where \"user\".login = :login ) a, \"user\" join account on account.owner_login = \"user\".login " +
            "where account.id = a.destination_id ", nativeQuery = true)
    public List<User> listUserFriends(@org.springframework.data.repository.query.Param("login") String login);

/*
    @Query(value = "select \"user\".login, \"user\".birthday, \"user\".cash_id, \"user\".group_id from \"user\" " +
            "where \"user\".login like ('%' || :part || '%') ", nativeQuery = true)
    public List<User> listPartUsers(@org.springframework.data.repository.query.Param("part") String part);
*/

    List<User> findByLoginContainingIgnoreCase(String part); //jpa magic!

//    @Query("select u from User u where u.login = :login")
//    User findByLogin(@Param("login") String login);
}