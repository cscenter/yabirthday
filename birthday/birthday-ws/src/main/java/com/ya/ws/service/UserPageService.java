package com.ya.ws.service;

import com.ya.domain.AccountService;
import com.ya.domain.GiftService;
import com.ya.domain.TransactionService;
import com.ya.domain.UserService;
import com.ya.domain.model.User;
import com.ya.ws.dto.*;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
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
    @Inject
    TransactionService transactionService;
    @Inject
    AccountService accountService;
    @Inject
    GiftService giftService;

    @GET
    @Path("/{login}")
    public UserPageDTO mainPage(@PathParam("login") String login) {
        return convert_userPage(userService.get(login));
    }

    @GET
    @Path("/users/")
    public List<UserDTO> listUsers() {
        return userService.list().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @GET
    @Path("/search/{part}")
    public List<UserDTO> listPartUsers(@PathParam("part") String part) {
        return userService.listPart(part).stream().map(UserDTO::new).collect(Collectors.toList());
    }


/*
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
    } */
/*
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
*/

    private long howMuchMoney(User user) {
        List<AccountDTO> accounts = accountService.listUserAccounts(user.getLogin()).stream().map(AccountDTO::new).collect(Collectors.toList());
        long funds = 0;
        for(int i = 0; i < accounts.size(); i++) {
            funds += accounts.get(i).getFunds();
        }
        return funds;
    }

    private UserPageDTO convert_userPage(User user) {
        return new UserPageDTO(new UserDTO(user), //new CashDTO(user.getCash()),
             //   accountService.listUserAccounts(user.getLogin()).stream().map(AccountDTO::new).collect(Collectors.toList()),
                userService.listTransactions(user.getLogin()).stream().map(TransactionDTO::new).collect(Collectors.toList()),
                userService.listUserFriends(user.getLogin()).stream().map(UserDTO::new).collect(Collectors.toList()),
                giftService.listUserGifts(user.getLogin()).stream().map(GiftDTO::new).collect(Collectors.toList()),
                howMuchMoney(user));
    }
}
