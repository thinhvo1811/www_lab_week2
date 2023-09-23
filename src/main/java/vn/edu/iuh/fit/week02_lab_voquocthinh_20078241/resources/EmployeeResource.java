//package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.resources;
//
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.Response;
//import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
//import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.EmployeeService;
//import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl.EmployeeServiceImpl;
//
//import java.util.List;
//import java.util.Optional;
//
//@Path("/employees")
//
//public class EmployeeResource {
//
//    private final EmployeeService employeeService;
//
//    public EmployeeResource() {
//        employeeService = new EmployeeServiceImpl();
//    }
//
//
//    @GET
//    @Produces("application/json")
//    @Path("/{id}")
//    public Response getEmp(@PathParam("id") long eid) {
//        Optional<Employee> empOpt = employeeService.findByID(eid);
//        if (empOpt.isPresent()) {
//            return Response.ok(empOpt.get()).build();
//        }
//        return Response.status(Response.Status.BAD_REQUEST).build();
//    }
//
//    @GET
//    @Produces("application/json")
//    public Response getAll() {
//        //paging if possible
//        List<Employee> lst = employeeService.getAll();
//        return Response.ok(lst).build();
//    }
//
//    @POST
//    @Produces("application/json")
//    @Consumes("application/json")
//    public Response insert(Employee employee) {
//        //ResponseEntity
//        employeeService.insert(employee);
//        return Response.ok(employee).build();
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response delete(@PathParam("id") long id) {
//        if (employeeService.delete(id))
//            return Response.ok().build();
//        return Response.status(Response.Status.NOT_FOUND).build();
//    }
//}
