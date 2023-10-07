package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Customer;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;

import java.sql.Date;
import java.util.ArrayList;
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

    public Customer getCustomerByEmailAndPhone(String email, String phone){
        Transaction tr = null;
        try (Session session = sessionFactory.openSession()){
            tr = session.beginTransaction();
            String sql = "SELECT * FROM customers WHERE email = '"+email+"' AND phone = '"+phone+"'";
            List<Object[]> list = session.createNativeQuery(sql, Object[].class).getResultList();
            Customer customer = findByID(Customer.class, list.get(0)[0]).get();
            tr.commit();
            return customer;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public List<Order> getOrdersByCustomerID(long custID) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Order where customer.id = :custid");
        query.setParameter("custid",custID);
        List<Order> list = query.getResultList();
        transaction.commit();
        return list;
    }
}
