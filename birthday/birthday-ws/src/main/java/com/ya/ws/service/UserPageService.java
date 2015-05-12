package com.ya.ws.service;

import com.ya.domain.AccountService;
import com.ya.domain.TransactionService;
import com.ya.domain.UserService;
import com.ya.domain.model.Account;
import com.ya.domain.model.Transaction;
import com.ya.domain.model.User;
import com.ya.ws.dto.*;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    @GET
    @Path("/main/")
    public UserPageDTO mainPage() {
        User a = userService.get("kulikov");
        return convert(a);
    }

    @GET
    @Path("/geh/")
    public List<UserDTO> qwer() {
        return userService.list()
                .stream()
                .map(this::convert_s)
                .collect(Collectors.toList());
    }
/*
    @GET
    @Path("/olya/")
    public List<AccountDTO> qwer_olya() {
        return accountService.listFriendsAccounts("kulikova").stream().map(this::convert_account).collect(Collectors.toList());
    } */

    @GET
    @Path("/lol/")
    public List<TransactionDTO> superRavil() {
        return transactionService.listAccountTransactions(2).stream().map(this::convert_transaction).collect(Collectors.toList());
    }


    private TransactionDTO convert_transaction(Transaction transaction) {
        return new TransactionDTO(transaction);
    }

    private AccountDTO convert_account(Account account) {
        return new AccountDTO(account);
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
*/

    private UserDTO convert_s(User user) {
        return new UserDTO(user.getLogin(), user.getBirthday(), new GroupDTO(user.getGroup()));
    }

    private UserPageDTO convert(User user) {

        return new UserPageDTO(new UserDTO(user), new CashDTO(user.getCash()),
                //user.getUserAccs().stream().map(AccountDTO::new).collect(Collectors.toList()),
                //user.getGiftsOwned().stream().map(GiftDTO::new).collect(Collectors.toList()),
                userService.listTransactions(user.getLogin()).stream().map(TransactionDTO::new).collect(Collectors.toList()));
                //userService.listFriends(user.getLogin()).stream().map(UserDTO::new).collect(Collectors.toList()));
    }
}

