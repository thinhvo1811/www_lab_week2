package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;


import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository extends GenericCRUD<Employee> {
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
    public List<Employee> getOrdersByPeriod() {
        Transaction tr = null;
        try (Session session = sessionFactory.openSession()){
            tr = session.beginTransaction();
            String sql = "SELECT emp_id,address FROM employees";
            List<Object[]> list = session.createNativeQuery(sql, Object[].class).getResultList();
            List<Employee> orders = new ArrayList<>();
            for (Object[] o: list) {
                orders.add(findByID(Employee.class,(long)o[0]).get());
            }
            tr.commit();
            return orders;
        } catch (Exception e) {
            // TODO: handle exception
//            logger.error(e.getMessage());
            tr.rollback();
        }
        return null;
    }
}