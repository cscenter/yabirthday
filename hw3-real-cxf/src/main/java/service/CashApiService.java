package service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by olya on 05.04.15.
 */

@Path("/cash/")
@Produces("text/json") //"application/json" ?
public class CashApiService {

    @GET
    @Path("/")
    public String getList() {
        //тут надо по идее считать сумму. Или не надо?
    }

    @GET
    @Path("/{owner}/")
    public String getCash(@PathParam("owner") String owner) {

    }

    @POST
    @Path("/{login}/")
    public Response addAccount(@PathParam("login") String login) {
        //что возвращать тут
    }

}
