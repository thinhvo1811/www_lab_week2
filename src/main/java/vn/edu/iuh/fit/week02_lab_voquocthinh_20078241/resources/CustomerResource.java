package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Customer;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.CustomerService;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl.CustomerServiceImpl;

import java.util.List;

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
}
