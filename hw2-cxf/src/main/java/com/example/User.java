package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Date;

@Path("/test/")
@Produces("text/html")
public class User {

    int id;
    String name;
    Date birthday;
    ArrayList friends;

    public User() {
        id = 42;
        name = new String("Super_hero");
        birthday = new Date(1993,11, 18); //устарела, да. Но нового не появилось
        friends = new ArrayList();
        friends.add(12);
        friends.add(14);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

  /*  @GET
    @Path("/{id}/")
    public void getUser(@PathParam("id") String id) {
        System.out.println("Success! id is: " + id);
    } */

    @GET
    @Path("/")
    public String printPage() {
        System.out.println("We are at printPage");
        String header =  "<html>\n" + " <head>\n" + "  <meta charset=\"utf-8\">\n" +
                " </head>\n" + " <body>\n";

        String form = "<form method=\"get\">\n" +
                "    <p><b>GET request:\n</b>" +
                "    <input type=\"text\" size=\"40\" name=\"req\"  value=\"\" />" +
                "    <input type=\"submit\" value=\"GET\" />\n" +
                "  </form>";
        String footer = "</body></html>";
        String answer = header + form + footer;
        return answer;
    }

    @GET
    @Path("/{id}/")
    public String getUser(@PathParam("id") String idFromUser) {
        System.out.println("We are at getUser");
        int id = Integer.parseInt(idFromUser);
        User user = new User();
        String header =  "<html>\n" + " <head>\n" + "  <meta charset=\"utf-8\">\n" +
                " </head>\n" + " <body>\n";
        String form;
        if (user.getId() == id) {
            form = user.getName();
        }
        else {
            form = "No user with this number. Try 42";
        }
        String footer = "</body></html>";
        String answer = header + form + footer;
        return answer;
    }
}


/*
import java.util.HashMap;
        import java.util.Map;

        import javax.ws.rs.DELETE;
        import javax.ws.rs.GET;
        import javax.ws.rs.POST;
        import javax.ws.rs.PUT;
        import javax.ws.rs.Path;
        import javax.ws.rs.PathParam;
        import javax.ws.rs.Produces;
        import javax.ws.rs.core.Response;

@Path("/customerservice/")
@Produces("text/xml")
public class CustomerService {
    long currentId = 123;
    Map<Long, Customer> customers = new HashMap<Long, Customer>();
    Map<Long, Order> orders = new HashMap<Long, Order>();

    public CustomerService() {
        init();
    }

    @GET
    @Path("/customers/{id}/")
    public Customer getCustomer(@PathParam("id") String id) {
        System.out.println("----invoking getCustomer, Customer id is: " + id);
        long idNumber = Long.parseLong(id);
        Customer c = customers.get(idNumber);
        return c;
    }

    @PUT
    @Path("/customers/")
    public Response updateCustomer(Customer customer) {
        System.out.println("----invoking updateCustomer, Customer name is: " + customer.getName());
        Customer c = customers.get(customer.getId());
        Response r;
        if (c != null) {
            customers.put(customer.getId(), customer);
            r = Response.ok().build();
        } else {
            r = Response.notModified().build();
        }

        return r;
    }

    @POST
    @Path("/customers/")
    public Response addCustomer(Customer customer) {
        System.out.println("----invoking addCustomer, Customer name is: " + customer.getName());
        customer.setId(++currentId);

        customers.put(customer.getId(), customer);

        return Response.ok(customer).build();
    }

    @DELETE
    @Path("/customers/{id}/")
    public Response deleteCustomer(@PathParam("id") String id) {
        System.out.println("----invoking deleteCustomer, Customer id is: " + id);
        long idNumber = Long.parseLong(id);
        Customer c = customers.get(idNumber);

        Response r;
        if (c != null) {
            r = Response.ok().build();
            customers.remove(idNumber);
        } else {
            r = Response.notModified().build();
        }

        return r;
    }

    @Path("/orders/{orderId}/")
    public Order getOrder(@PathParam("orderId") String orderId) {
        System.out.println("----invoking getOrder, Order id is: " + orderId);
        long idNumber = Long.parseLong(orderId);
        Order c = orders.get(idNumber);
        return c;
    }

    final void init() {
        Customer c = new Customer();
        c.setName("John");
        c.setId(123);
        customers.put(c.getId(), c);

        Order o = new Order();
        o.setDescription("order 223");
        o.setId(223);
        orders.put(o.getId(), o);
    }

} */