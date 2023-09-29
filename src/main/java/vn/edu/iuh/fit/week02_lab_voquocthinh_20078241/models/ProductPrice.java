package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_prices")
public class ProductPrice {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @Column(name = "price_date_time")
    private LocalDateTime priceDateTime;
    private double price;
    private String note;

    public ProductPrice() {
    }

    public ProductPrice(Product product, LocalDateTime priceDateTime, double price, String note) {
        this.product = product;
        this.priceDateTime = priceDateTime;
        this.price = price;
        this.note = note;
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                ", priceDateTime=" + priceDateTime +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
