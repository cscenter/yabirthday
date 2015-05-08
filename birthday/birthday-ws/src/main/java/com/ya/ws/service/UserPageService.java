package com.ya.ws.service;

import com.ya.domain.UserService;
import com.ya.domain.model.User;
import com.ya.ws.dto.UserDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Created by olya on 07.05.15.
 */
@Service
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserPageService {

    @Inject
    UserService userService;

    @GET
    @Path("/")
    public List<UserDTO> list() {
        return userService.list()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @GET
    @Path("{login}")
    public UserDTO get(@PathParam("login") String login) {
        if (login == null) {
            throw new BadRequestException("Login is null");
        }
        try {
            return convert(userService.get(login));
        } catch (NoSuchElementException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @POST
    public UserDTO create(UserDTO user) {
        if (user == null) {
            throw new BadRequestException("User is null");
        } else if (user.getLogin() == null) {
            throw new BadRequestException("User login is null");
        } else if (user.getBirthday() == null) {
            throw new BadRequestException("User birthday is null");
        }
        return convert(userService.create(user.getLogin(), user.getBirthday()));
    }

    @PUT
    @Path("{login}")
    public UserDTO update(@PathParam("login") String login, UserDTO user) {
        if (login == null) {
            throw new BadRequestException("Login is null");
        } else if (user == null) {
            throw new BadRequestException("User is null");
        } else if (user.getBirthday() == null) {
            throw new BadRequestException("User birthday is null");
        }
        try {
            return convert(userService.update(login, user.getBirthday()));
        } catch (NoSuchElementException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @DELETE
    @Path("{login}")
    public UserDTO remove(@PathParam("login") String login) {
        if (login == null) {
            throw new BadRequestException("Login is null");
        }
        try {
            return convert(userService.remove(login));
        } catch (NoSuchElementException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    private UserDTO convert(User user) {
        return new UserDTO(user.getLogin(), user.getBirthday());
    }
}

