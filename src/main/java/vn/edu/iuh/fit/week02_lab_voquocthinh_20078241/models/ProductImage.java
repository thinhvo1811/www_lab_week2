package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product_image")
@IdClass(ProductImage.ProductImagePK.class)
public class ProductImage {
    @Id
    @Column(name = "product_id")
    private long productID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long imageID;
    @Column(length = 250, nullable = false)
    private String path;
    @Column(length = 250)
    private String alternative;

    public ProductImage() {
    }

    public ProductImage(long productID, String path, String alternative) {
        this.productID = productID;
        this.path = path;
        this.alternative = alternative;
    }

    public long getproductID() {
        return productID;
    }

    public void setproductID(long productID) {
        this.productID = productID;
    }

    public long getimageID() {
        return imageID;
    }

    public void setimageID(long imageID) {
        this.imageID = imageID;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "productID=" + productID +
                ", imageID=" + imageID +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }

    public static class ProductImagePK implements Serializable{
        private long productID;
        private long imageID;

        public ProductImagePK() {
        }

        public ProductImagePK(long productID, long imageID) {
            this.productID = productID;
            this.imageID = imageID;
        }

        public long getProductID() {
            return productID;
        }

        public void setProductID(long productID) {
            this.productID = productID;
        }

        public long getImageID() {
            return imageID;
        }

        public void setImageID(long imageID) {
            this.imageID = imageID;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ProductImagePK)) return false;
            ProductImagePK that = (ProductImagePK) o;
            return getProductID() == that.getProductID() && getImageID() == that.getImageID();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getProductID(), getImageID());
        }

        @Override
        public String toString() {
            return "ProductImagePK{" +
                    "productID=" + productID +
                    ", imageID=" + imageID +
                    '}';
        }
    }
}
