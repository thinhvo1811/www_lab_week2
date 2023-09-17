package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_detail")
@IdClass(OrderDetail.OrderDetailPK.class)
public class OrderDetail {
    @Id
    @Column(name = "order_id")
    private long orderID;
    @Id
    @Column(name = "product_id")
    private long productID;
    private double quantity;
    private String note;

    public static class OrderDetailPK implements Serializable{
        private long orderID;
        private long productID;

        public OrderDetailPK() {
        }

        public OrderDetailPK(long orderID, long productID) {
            this.orderID = orderID;
            this.productID = productID;
        }

        public long getOrderID() {
            return orderID;
        }

        public void setOrderID(long orderID) {
            this.orderID = orderID;
        }

        public long getProductID() {
            return productID;
        }

        public void setProductID(long productID) {
            this.productID = productID;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof OrderDetailPK)) return false;
            OrderDetailPK that = (OrderDetailPK) o;
            return getOrderID() == that.getOrderID() && getProductID() == that.getProductID();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getOrderID(), getProductID());
        }

        @Override
        public String toString() {
            return "OrderDetailPK{" +
                    "orderID=" + orderID +
                    ", productID=" + productID +
                    '}';
        }
    }
}
