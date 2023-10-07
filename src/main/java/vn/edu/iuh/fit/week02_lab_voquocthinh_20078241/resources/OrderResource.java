package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.OrderService;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl.OrderServiceImpl;

import java.util.List;

@Path("/orders")
public class OrderResource {
    private final OrderService orderService;

    public OrderResource() {
        orderService = new OrderServiceImpl();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        //paging if possible
        List<Order> lst = orderService.getAll();
        return Response.ok(lst).build();
    }
}
