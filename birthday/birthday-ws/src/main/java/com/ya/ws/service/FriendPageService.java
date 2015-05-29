package com.ya.ws.service;

import com.ya.domain.service.AccountService;
import com.ya.domain.service.UserService;
import com.ya.ws.dto.AccountDTO;
import com.ya.ws.dto.FriendPageDTO;
import com.ya.ws.dto.UserDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by olya on 19.05.15.
 */

@Service
@Path("/friend")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FriendPageService {

    @Inject
    UserService userService;

    @Inject
    AccountService accountService;

    @GET
    @Path("/{login}")
    public FriendPageDTO friendPage(@PathParam("login") String login) {
        return convertFriendPage(login);
    }

    @GET
    @Path("/{login}/{part}")
    public FriendPageDTO searchPage(@PathParam("login") String login, @PathParam("part") String part) {
        return convertFriendPagePart(login, part);
    }

    @PUT
    @Path("/{login}/{friendLogin}")
    public AccountDTO addFriend(@PathParam("login") String login, @PathParam("friendLogin") String friendLogin) {
        return new AccountDTO(userService.addFriend(login, friendLogin));
    }

    @DELETE
    @Path("/{login}/{friendLogin}")
    public AccountDTO removeFriend(@PathParam("login") String login, @PathParam("friendLogin") String friendLogin) {
        return new AccountDTO(userService.removeFriend(login, friendLogin));
    }

    private long howMuchMoney(String login) {
        List<AccountDTO> accounts = accountService.listUserAccounts(login).stream().map(AccountDTO::new).collect(Collectors.toList());
        long funds = 0;
        for(int i = 0; i < accounts.size(); i++) {
            funds += accounts.get(i).getFunds();
        }
        return funds;
    }

    private FriendPageDTO convertFriendPage(String login) {
        List<UserDTO> users = userService.list().stream().map(UserDTO::new).collect(Collectors.toList());
        List<UserDTO> friends = userService.listUserFriends(login).stream().map(UserDTO::new).collect(Collectors.toList());
        List<Integer> status = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (friends.contains(users.get(i))) {
                status.add(0);
            }
            else if (users.get(i).getLogin().compareTo(login) == 0) {
                status.add(1);
            }
            else {
                status.add(2);
            }
        }
        return new FriendPageDTO(users, status,
                accountService.listUserAccounts(login).stream().map(AccountDTO::new).collect(Collectors.toList()),
                howMuchMoney(login));
    }

    private FriendPageDTO convertFriendPagePart(String login, String part) {
        List<UserDTO> users = userService.listPart(part).stream().map(UserDTO::new).collect(Collectors.toList());
        List<UserDTO> friends = userService.listUserFriends(login).stream().map(UserDTO::new).collect(Collectors.toList());
        List<Integer> status = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (friends.contains(users.get(i))) {
                status.add(0);
            }
            else if (users.get(i).getLogin().compareTo(login) == 0) {
                status.add(1);
            }
            else {
                status.add(2);
            }
        }
        return new FriendPageDTO(users, status,
                accountService.listUserAccounts(login).stream().map(AccountDTO::new).collect(Collectors.toList()),
                howMuchMoney(login));
    }

}
