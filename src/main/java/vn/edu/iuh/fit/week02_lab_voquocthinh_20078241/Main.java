package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241;

import jakarta.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.converters.EmployeeStatusConverter;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Customer;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Product;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories.*;


import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MySessionFactory.getInstance();

//        OrderRepository orderRepository = new OrderRepository();
//        List<Order> orders = orderRepository.getOrdersByPeriod(Date.valueOf("2023-09-23"),Date.valueOf("2023-09-26"));

//        EmployeeRepository employeeRepository = new EmployeeRepository();
//        Boolean b = employeeRepository.insert(new Employee("a", LocalDateTime.now(), "e", "a", "a", EmployeeStatus.TERMINATED, null));
//        System.out.println(b);
//        List<Employee> orders = employeeRepository.getAll();
//        List<Order> orders = employeeRepository.getOrdersByPeriod(1L,Date.valueOf("2023-09-20"), Date.valueOf("2023-09-30"));

//        ProductRepository productRepository = new ProductRepository();
//        List<Product> products = productRepository.getProductsByKeyword("Mũ");
//
//        products.forEach(System.out::println);

//        CustomerRepository customerRepository = new CustomerRepository();
//        List<Customer> customers = customerRepository.getAll();
//        customers.forEach(System.out::println);
    }
}
