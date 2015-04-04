package service;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by olya on 03.04.15.
 */

@Path("/")
@Produces("text/json") //"application/json" ?
public class UserApiService {

    @GET
    @Path("/")
    public String getList() {

    }

    @GET
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
    }
}