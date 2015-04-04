package service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by olya on 05.04.15.
 */

@Path("/account/")
@Produces("text/json") //"application/json" ?
public class AccountApiService {

    @GET
    @Path("/")
    public String getList() {

    }

    @GET
    @Path("/{id}/")
    public String getAccount(@PathParam("id") String id) {

    }

    @PUT
    @Path("/{id}/")
    public Response updateAccount(@PathParam("id") String id) {
        //что возвращать тут
        //не знаю вообще, как PUT писать... разберусь, когда можно будет тестить, надеюсь
    }
}
