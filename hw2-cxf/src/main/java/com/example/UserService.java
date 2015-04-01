package com.example;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Path("/")
@Produces("text/html")
public class UserService {

    User user;
    Statement statement;

    public UserService(Statement st) {
        user = new User();
        statement = st;
    }



    @GET
    @Path("/")
    public String printPage() {
        System.out.println("We are at printPage");
        String header =  "<html>\n" + " <head>\n" + "  <meta charset=\"utf-8\">\n" +
                " </head>\n" + " <body>\n";

        String form = "<form action = \"User/\" method=\"get\">\n" +
                "    <p><b>GET request:\n</b>" +
                "    <input type=\"text\" size=\"40\" name=\"id\"  value=\"\" />" +
                "    <input type=\"submit\" value=\"GET\" />\n" +
                "  </form>";
        form += "<form action = \"User/\" method=\"put\">\n" +
                "    <p><b>PUT request:\n</b>" +
                "    <input type=\"text\" size=\"40\" name=\"id\"  value=\"\" />" +
                "    <input type=\"submit\" value=\"PUT\" />\n" +
                "  </form>";
        form += "<form action = \"User/try/\" method=\"post\">\n" +
                "    <p><b>POST request:\n</b>" +
                "    <input type=\"text\" size=\"40\" name=\"id\"  value=\"\" />" +
                "    <input type=\"submit\" value=\"POST\" />\n" +
                "  </form>";
        String footer = "</body></html>";
        String answer = header + form + footer;
        return answer;
    }

  /*  @GET
    @Path("/User/")
    public String getUser(@QueryParam("id") String idFromUser) {
        System.out.println("We are at getUser");
        int id = Integer.parseInt(idFromUser);
        String header =  "<html>\n" + " <head>\n" + "  <meta charset=\"utf-8\">\n" +
                " </head>\n" + " <body>\n";
        String form;
        if (user.getId() == id) {
            form = user.getName();
        }
        else {
            form = "No user with this number. Try " + user.getId();
        }
        String footer = "</body></html>";
        String answer = header + form + footer;
        return answer;
    } */

    @GET
    @Path("/User/{id}/")
    public String getUserByPath(@PathParam("id") String idFromUser) {
        System.out.println("We are at getUser");
        String header =  "<html>\n" + " <head>\n" + "  <meta charset=\"utf-8\">\n" +
                " </head>\n" + " <body>\n";
        String form = "Yes, it also works. You have put there " + idFromUser;
        String footer = "</body></html>";
        String answer = header + form + footer;
        return answer;
    }

    @GET
    @Path("/User/")
    public String getUsers(@QueryParam("id") String query) {
        System.out.println("We are at getUsers");
        String header =  "<html>\n" + " <head>\n" + "  <meta charset=\"utf-8\">\n" +
                " </head>\n" + " <body>\n";
        String form = "";
        ResultSet toWrite;
        try {
            toWrite = statement.executeQuery(query); //"SELECT * FROM users"
            form += "<table border=\"1\"><tr><th>Login</th><th>Birthday</th></tr>";
            while (toWrite.next()) {
                form += "<tr><td>" + toWrite.getString("login") + "</td><td>" + toWrite.getDate("birthday") + "</td></tr>";
            }
            form += "</table>";
        }
        catch (SQLException e) {
            e.printStackTrace();
            form = "<h1>Error with reading DataBase</h1>";
        }

        String footer = "</body></html>";
        String answer = header + form + footer;
        return answer;
    }

   /* @PUT
    @Path("/User/")
    public String updateUserFriends(@QueryParam("id") String friend) {
        System.out.println("We are at updateUserFriends");
        int id_of_friend = Integer.parseInt(friend);
       // Response r;
        user.friends.add(id_of_friend);
      //  r = Response.ok().build();
       // return r;
        String header =  "<html>\n" + " <head>\n" + "  <meta charset=\"utf-8\">\n" +
                " </head>\n" + " <body>\n";
        String form = "SUCCESS!!! You have put " + friend;
        String footer = "</body></html>";
        String answer = header + form + footer;
        return answer;
    } */

    @PUT
    @Path("/User/")
    public Response updateUserFriends(@QueryParam("id") String friend) {
        System.out.println("We are at updateUserFriends");
        int id_of_friend = Integer.parseInt(friend);
        // Response r;
        user.friends.add(id_of_friend);
        //  r = Response.ok().build();
        // return r;
        String header =  "<html>\n" + " <head>\n" + "  <meta charset=\"utf-8\">\n" +
                " </head>\n" + " <body>\n";
        String form = "SUCCESS!!! You have put " + friend;
        String footer = "</body></html>";
        String answer = header + form + footer;
        return Response.ok(answer).build();
    }

   /* @POST
    @Path("/User/")
    public String changeId(@QueryParam("id") String strId) {
        System.out.println("We are at changeId");
        int id = Integer.parseInt(strId);
        user.setId(id);
        String header =  "<html>\n" + " <head>\n" + "  <meta charset=\"utf-8\">\n" +
                " </head>\n" + " <body>\n";
        String form = "SUCCESS!!! You have changed id, now it is " + user.getId();
        String footer = "</body></html>";
        String answer = header + form + footer;
        return answer;
    } */

  /*  @POST
    @Path("/User/try/")
    public Response changeId(@QueryParam("id") String strId) {
        System.out.println("We are at changeId");
        int id = Integer.parseInt(strId);
        user.setId(id);
        String header =  "<html>\n" + " <head>\n" + "  <meta charset=\"utf-8\">\n" +
                " </head>\n" + " <body>\n";
        String form = "SUCCESS!!! You have changed id, now it is " + user.getId();
        String footer = "</body></html>";
        String answer = header + form + footer;
        return Response.ok(id).build();
    } */

    @POST
    @Path("/User/try/")
    public String changeId(@FormParam("id") String strId) {
        System.out.println("We are at changeId");
        //user.setId(user.getId() + 1);
        int id = Integer.parseInt(strId);
        user.setId(id);
        String header =  "<html>\n" + " <head>\n" + "  <meta charset=\"utf-8\">\n" +
                " </head>\n" + " <body>\n";
        String form = "SUCCESS!!! You have changed id, now it is " + user.getId();
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