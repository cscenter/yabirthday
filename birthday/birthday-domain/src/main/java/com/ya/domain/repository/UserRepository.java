package com.ya.domain.repository;

import com.ya.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {

    User findByLogin(String login);

//    @Query("select u from User u where u.login = :login")
//    User findByLogin(@Param("login") String login);
}
