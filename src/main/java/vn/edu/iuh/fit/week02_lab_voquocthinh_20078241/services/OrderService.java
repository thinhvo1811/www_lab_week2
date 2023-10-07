package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services;

import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;

import java.sql.Date;
import java.util.List;

public interface OrderService {
    public List<Order> getAll();
    public List<Order> getOrdersByDate(Date date);
    public List<Order> getOrdersByPeriod(Date from, Date to);
}
