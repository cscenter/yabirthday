package com.ya.domain.repository;

import com.ya.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByLogin(String login);
/*
    @Query("select distinct u from User u join account on account.owner_login = u.login " +
            "where account.id in :accounts")
    public List<User> listUserFriends(@org.springframework.data.repository.query.Param("login") List<Long> accounts);
*/

//    @Query("select u from User u where u.login = :login")
//    User findByLogin(@Param("login") String login);
}
/*
select u from user u join account on account.owner_login = user.login
join account_receiver on account.id = account_receiver.source_id
where user.login = :login
 */