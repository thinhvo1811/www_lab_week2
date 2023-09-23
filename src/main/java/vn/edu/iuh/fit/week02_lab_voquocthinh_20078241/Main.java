package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241;

import jakarta.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.converters.EmployeeStatusConverter;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories.EmployeeRepository;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories.MySessionFactory;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories.OrderRepository;


import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MySessionFactory.getInstance();
//        EmployeeRepository employeeRepository = new EmployeeRepository();
        OrderRepository orderRepository = new OrderRepository();
//        Boolean b = employeeRepository.insert(new Employee("a", LocalDateTime.now(), "e", "a", "a", EmployeeStatus.TERMINATED, null));
        List<Order> employees = orderRepository.getOrdersByPeriod(1L,Date.valueOf("2023-09-20"), Date.valueOf("2023-09-30"));
        employees.forEach(System.out::println);
//        System.out.println(b);
//        List<Employee> orders = employeeRepository.getAll();
//        orders.forEach(System.out::println);

    }
}
