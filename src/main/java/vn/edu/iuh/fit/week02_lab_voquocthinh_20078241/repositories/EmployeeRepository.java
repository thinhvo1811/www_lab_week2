package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository extends GenericCRUD<Employee>{
    public void setStatus(Employee employee, EmployeeStatus status) {
        employee.setStatus(status);
    }

    public List<Employee> getAll() {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Employee> employees = session.createNamedQuery("Employee.findAll", Employee.class)
                .setParameter(1, EmployeeStatus.ACTIVE)
                .getResultList();
        transaction.commit();
        return employees;
    }

    public List<Order> getOrdersByPeriod(long empID, Date from, Date to) {
        Transaction tr = null;
        try (Session session = sessionFactory.openSession()){
            tr = session.beginTransaction();
            String sql = "SELECT order_id, order_date, cust_id, o.emp_id from employees e INNER JOIN orders o ON e.emp_id = o.emp_id WHERE o.emp_id = "+empID+" AND o.order_date BETWEEN '"+from+"' AND '"+to+"'";
            List<Object[]> list = session.createNativeQuery(sql, Object[].class).getResultList();
            List<Order> orders = new ArrayList<>();
            for (Object[] o: list) {
                orders.add(session.find(Order.class,o[0]));
            }
            tr.commit();
            return orders;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e.getMessage());
            tr.rollback();
        }
        return null;
    }
}