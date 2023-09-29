package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services;

import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Customer;

import java.util.List;

public interface CustomerService {
    public boolean insert(Customer customer);
    public List<Customer> getAll();
}
