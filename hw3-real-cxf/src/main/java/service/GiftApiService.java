package service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by olya on 05.04.15.
 */

@Path("/gift/")
@Produces("text/json") //"application/json" ?
public class GiftApiService {

    @GET
    @Path("/")
    public String getList() {

    }

    @GET
    @Path("/{id}/")
    public String getGift(@PathParam("id") String id) {

    }

    @PUT
    @Path("/")
    public Response updateGift() {
        //что возвращать тут
    }

    @POST
    @Path("/")
    public Response addGift() {
        //что возвращать тут
    }
}
