package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl;

import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Customer;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories.CustomerRepository;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.CustomerService;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl() {
        customerRepository = new CustomerRepository();
    }

    @Override
    public boolean insert(Customer customer) {
        return customerRepository.insert(customer);
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public Customer getCustomerByEmailAndPhone(String email, String phone) {
        return customerRepository.getCustomerByEmailAndPhone(email, phone);
    }

    @Override
    public List<Order> getOrdersByCustomerID(long custID) {
        return customerRepository.getOrdersByCustomerID(custID);
    }

    @Override
    public Optional<Customer> findByID(long id) {
        return customerRepository.findByID(Customer.class, id);
    }
}
