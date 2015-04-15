package service;

import DTO.UserPageDTO;
import com.company.TempDB;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by olya on 15.04.15.
 */
@Path("/")
@Produces("application/json")
public class UserPageService {

    @GET
    @Path("/")
    public UserPageDTO getUserPage() {
        return TempDB.getPage();
    }
/*
    @GET
    @Path("/{login}/")
    public UserDTO getUser(@PathParam("login") String login) {

    }

    @PUT
    @Path("/{login}/")
    public UserPageDTO updateUser(@PathParam("login") String login) {
        //как сюда передать всю инфу
    } */
}
