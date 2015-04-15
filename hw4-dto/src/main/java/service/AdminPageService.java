package service;

import DTO.AccountDTO;
import DTO.AdminPageDTO;

import javax.ws.rs.*;

/**
 * Created by olya on 15.04.15.
 */
@Path("/admin/")
@Produces("application/json")
public class AdminPageService {
    @GET
    @Path("/")
    public AdminPageDTO getAdminPage() {

    }

    @GET
    @Path("/{id}/")
    public AccountDTO getAccount(@PathParam("id") long id) {

    }

    @PUT
    @Path("/{id}/") //или login?
    public AccountDTO updateAccount(@PathParam("id") long id) {

    }

    @POST
    @Path("/")
    public AdminPageDTO createGift() {

    }

    @DELETE
    @Path("/{id}/")
    public AdminPageDTO deleteGift(@PathParam("id") long id) {

    }
}
