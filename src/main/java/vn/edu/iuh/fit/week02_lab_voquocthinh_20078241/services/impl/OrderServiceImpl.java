package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl;

import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories.OrderRepository;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.OrderService;

import java.sql.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl() {
        orderRepository = new OrderRepository();
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public List<Order> getOrdersByDate(Date date) {
        return orderRepository.getOrdersByDate(date);
    }

    @Override
    public List<Order> getOrdersByPeriod(Date from, Date to) {
        return orderRepository.getOrdersByPeriod(from, to);
    }

    @Override
    public List<Order> getOrdersByEmpAndPeriod(long empID, Date from, Date to) {
        return orderRepository.getOrdersByEmpAndPeriod(empID,from,to);
    }
}
