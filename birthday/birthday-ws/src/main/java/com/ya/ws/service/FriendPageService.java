package com.ya.ws.service;

import com.ya.domain.service.UserService;
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
        return new FriendPageDTO(users, status);
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
        return new FriendPageDTO(users, status);
    }

}
