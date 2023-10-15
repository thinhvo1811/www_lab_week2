package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Customer;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Product;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.CustomerService;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl.CustomerServiceImpl;

import java.util.List;
import java.util.Optional;

@Path("/customers")
public class CustomerResource {
    private final CustomerService customerService;

    public CustomerResource() {
        customerService = new CustomerServiceImpl();
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
    public Response insert(Customer customer) {
        //ResponseEntity
        boolean b = customerService.insert(customer);
        if (b){
            return Response.ok(customer).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public Response update(Customer customer) {
        //ResponseEntity
        boolean b = customerService.update(customer);
        if (b){
            return Response.ok(customer).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    @Path("/login")
    public Response getCustomerByEmailAndPhone(@QueryParam("email") String email,@QueryParam("phone") String phone) {
        Customer customer = customerService.getCustomerByEmailAndPhone(email, phone);
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
