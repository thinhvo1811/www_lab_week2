package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "products")
@NamedQueries(
        @NamedQuery(name = "Product.findAll", query = "select p from Product p where p.status = ?1")
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;
    @Column(length = 150, nullable = false)
    private String name;
    @Column(length = 250, nullable = false)
    private String description;
    @Column(length = 25, nullable = false)
    private String unit;
    @Column(name = "manufacturer_name",length = 150, nullable = false)
    private String manufacturer;
    @Column(columnDefinition = "int", nullable = false)
    private ProductStatus status;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices;

    public Product() {
    }

    public Product(long id, String name, String description, String unit, String manufacturer, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
    }

    public Product(long id, String name, String description, String unit, String manufacturer, ProductStatus status, List<ProductImage> productImages, List<OrderDetail> orderDetails, List<ProductPrice> productPrices) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
        this.productImages = productImages;
        this.orderDetails = orderDetails;
        this.productPrices = productPrices;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

//    public List<OrderDetail> getOrderDetails() {
//        return orderDetails;
//    }

//    public void setOrderDetails(List<OrderDetail> orderDetails) {
//        this.orderDetails = orderDetails;
//    }

    public double getSoldQuantity(){
        double soldQuantity = 0;
        for(int i = 0; i<orderDetails.size();i++)
            soldQuantity += orderDetails.get(i).getQuantity();
        return soldQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", status=" + status +
                ", productImages=" + productImages +
                ", orderDetails=" + orderDetails +
                ", productPrices=" + productPrices +
                '}';
    }
}
