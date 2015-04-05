package service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
/**
 * Created by olya on 03.04.15.
 */

@Path("/")
@Produces("text/json") //"application/json" ?
public class UserApiService {

    @GET
    @Path("/")
    public String getList() {
        String result = "[";
        for (int i = 0; i < TempDB.users.size(); ++i) {
            result += "[" + TempDB.users.get(i).getLogin() + "," + TempDB.users.get(i).getBirthday().toString() + "]";
        }
        result += "]";
        return result;
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