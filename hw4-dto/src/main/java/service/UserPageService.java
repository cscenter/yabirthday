package service;

import DTO.UserDTO;
import DTO.UserPageDTO;

import javax.ws.rs.*;

/**
 * Created by olya on 15.04.15.
 */
@Path("/")
@Produces("application/json")
public class UserPageService {

    @GET
    @Path("/")
    public UserPageDTO getUserPage() {

    }

    @GET
    @Path("/{login}/")
    public UserDTO getUser(@PathParam("login") String login) {

    }

    @PUT
    @Path("/{login}/")
    public UserPageDTO updateUser(@PathParam("login") String login) {
        //как сюда передать всю инфу
    }
}
