package service;


import domain.User;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by olya on 03.04.15.
 */

@Path("/")
@Produces("application/json") //"text/json" ?
public class UserApiService {

    @GET
    @Path("/")
    public List<User> getList() {
        return TempDB.users;
    }



  /*  @GET
    @Path("/{login}/")
    public String getUser(@PathParam("login") String login) {

    }

    @GET
    @Path("/{login}/friends")
    public String getFriends(@PathParam("login") String login) {

    }

    @PUT
    @Path("/{login}/")
    public Response updateUser(@PathParam("login") String login) {
        //что возвращать тут
        //не знаю вообще, как PUT писать... разберусь, когда можно будет тестить, надеюсь
    } */
}