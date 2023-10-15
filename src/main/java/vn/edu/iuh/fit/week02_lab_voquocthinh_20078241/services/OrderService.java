package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services;

import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Product;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    public List<Order> getAll();
    public List<Order> getOrdersByDate(Date date);
    public List<Order> getOrdersByPeriod(Date from, Date to);
    public List<Order> getOrdersByEmpAndPeriod(long empID, Date from, Date to);
    public Optional<Order> findByID(long id);
    public boolean insert(Order order);
    public boolean update(Order order);
}
