package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Customer;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;

import java.util.List;

public class CustomerRepository extends GenericCRUD<Customer>{
    public List<Customer> getAll() {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Customer> customers = session.createNamedQuery("Customer.findAll", Customer.class)
                .getResultList();
        transaction.commit();
        return customers;
    }
}
