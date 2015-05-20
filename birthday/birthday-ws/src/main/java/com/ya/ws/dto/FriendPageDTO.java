package com.ya.ws.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olya on 19.05.15.
 */

public class FriendPageDTO {

    public class Friend {
        private final UserDTO user;
        private final int status;

        public Friend(UserDTO user, int status) {
            this.user = user;
            this.status = status;
        }

        public UserDTO getUser() {return  user;}

        public int getStatus() {return status;}

    }

    private final List<Friend> users;
    private final List<AccountDTO> userAccs;
    private final long money;


    public List<Friend> getUsers() {return users;}

    public List<AccountDTO> getUserAccs() {return userAccs;}

    public long getMoney() {return money;}

    public FriendPageDTO(List<UserDTO> users, List<Integer> status, List<AccountDTO> userAccs, long money) {
        List<Friend> tempUsers = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            tempUsers.add(new Friend(users.get(i), status.get(i)));
        }
        this.users = tempUsers;
        this.userAccs = userAccs;
        this.money = money;
    }
}
