package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services;

import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Customer;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public boolean insert(Customer customer);
    public boolean update(Customer customer);
    public List<Customer> getAll();
    public Customer getCustomerByEmailAndPhone(String email, String phone);
    public List<Order> getOrdersByCustomerID(long custID);
    public Optional<Customer> findByID(long id);
}
