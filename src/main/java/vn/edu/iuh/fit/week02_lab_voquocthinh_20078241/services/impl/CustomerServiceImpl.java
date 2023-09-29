package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl;

import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Customer;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories.CustomerRepository;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.CustomerService;

import java.util.List;

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
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
}
