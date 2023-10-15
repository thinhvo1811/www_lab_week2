package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Product;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.OrderService;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl.OrderServiceImpl;

import java.sql.Date;
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

    @GET
    @Produces("application/json")
    @Path("/searchbydate")
    public Response getOrdersByDate(@QueryParam("date") Date date){
        List<Order> orders = orderService.getOrdersByDate(date);
        if (orders!=null) {
            return Response.ok(orders).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces("application/json")
    @Path("/searchbyperiod")
    public Response getOrdersByPeriod(@QueryParam("fromdate") Date fromDate,@QueryParam("todate") Date toDate){
        List<Order> orders = orderService.getOrdersByPeriod(fromDate,toDate);
        if (orders!=null) {
            return Response.ok(orders).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces("application/json")
    @Path("/searchbyempandperiod")
    public Response getOrdersByEmployeeAndPeriod(@QueryParam("empID") long id, @QueryParam("fromdate") Date fromDate, @QueryParam("todate") Date toDate){
        List<Order> orders = orderService.getOrdersByEmpAndPeriod(id,fromDate,toDate);
        if (orders!=null) {
            return Response.ok(orders).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
