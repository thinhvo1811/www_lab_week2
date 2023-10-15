package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Customer;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Product;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.ProductService;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl.ProductServiceImpl;

import java.util.List;
import java.util.Optional;

@Path("/products")
public class ProductResource {
    private final ProductService productService;

    public ProductResource() {
        productService = new ProductServiceImpl();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Product> products = productService.getAll();
        return Response.ok(products).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getProduct(@PathParam("id") long id) {
        Optional<Product> proOpt = productService.findByID(id);
        if (proOpt.isPresent()) {
            return Response.ok(proOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    @Path("/manufacturers")
    public Response getAllManufacturers(){
        List<String> products = productService.getAllManufacturers();
        return Response.ok(products).build();
    }

    @GET
    @Produces("application/json")
    @Path("/search")
    public Response getProductsByKeyword(@QueryParam("keyword") String keyword){
        List<Product> products = productService.getProductsByKeyword(keyword);
        return Response.ok(products).build();
    }

    @GET
    @Produces("application/json")
    @Path("/filter")
    public Response getProductsByManufacturer(@QueryParam("manufacturer") String manufacturer){
        List<Product> products = productService.getProductsByManufacturer(manufacturer);
        return Response.ok(products).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        if (productService.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Product product) {
        //ResponseEntity
        boolean b = productService.insert(product);
        if (b){
            return Response.ok(product).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public Response update(Product product) {
        //ResponseEntity
        boolean b = productService.update(product);
        if (b){
            return Response.ok(product).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
