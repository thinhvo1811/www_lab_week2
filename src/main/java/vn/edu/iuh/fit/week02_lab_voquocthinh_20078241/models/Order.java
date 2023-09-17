package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;
    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employeeID;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customerID;

    @OneToMany(mappedBy = "orderID")
    private List<OrderDetail> orderDetails;
}
