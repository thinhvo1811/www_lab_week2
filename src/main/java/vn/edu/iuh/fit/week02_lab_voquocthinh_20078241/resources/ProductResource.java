package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Product;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.ProductService;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl.ProductServiceImpl;

import java.util.List;

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
}
