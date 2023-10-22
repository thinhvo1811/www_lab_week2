package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.UserType;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.*;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.CustomerService;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.UserService;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl.CustomerServiceImpl;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl.UserServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Path("/customers")
public class CustomerResource {
    private final CustomerService customerService;
    private final UserService userService;

    public CustomerResource() {
        customerService = new CustomerServiceImpl();
        userService = new UserServiceImpl();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        //paging if possible
        List<Customer> lst = customerService.getAll();
        return Response.ok(lst).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Object object) throws JSONException {
        //ResponseEntity
        JSONObject jsonObject = new JSONObject(object.toString());

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String name = jsonObject.getString("name");
        String email = jsonObject.getString("email");
        String phone = "0"+jsonObject.getString("phone");
        String address = jsonObject.getString("address");

        User user = new User(username, password, UserType.CUSTOMER);
        Customer customer = new Customer(name, email, phone, address, user);

        boolean isInsertUser = userService.insert(user);
        if (isInsertUser){
            boolean isInsertCustomer = customerService.insert(customer);
            if (isInsertCustomer){
                return Response.ok(customer).build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public Response update(Customer customer) {
        //ResponseEntity
        customer.setUser(customerService.findByID(customer.getId()).get().getUser());
        customer.setOrders(customerService.findByID(customer.getId()).get().getOrders());
        boolean b = customerService.update(customer);
        if (b){
            return Response.ok(customer).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    @Path("/login")
    public Response getCustomerByUsernameAndPassword(@QueryParam("username") String username,@QueryParam("password") String password) {
        Customer customer = customerService.getCustomerByUsernameAndPassword(username, password);
        if (customer!=null) {
            return Response.ok(customer).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces("application/json")
    @Path("/orders/{id}")
    public Response getOrdersByCustomerID(@PathParam("id") long custID) {
        List<Order> orders = customerService.getOrdersByCustomerID(custID);
        if (orders!=null) {
            return Response.ok(orders).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") long id) {
        Optional<Customer> cusOpt = customerService.findByID(id);
        if (cusOpt.isPresent()) {
            return Response.ok(cusOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
