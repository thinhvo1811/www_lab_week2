package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Customer;
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

    public Employee getEmployeeByUsernameAndPassword(String username, String password){
        Transaction tr = null;
        try (Session session = sessionFactory.openSession()){
            tr = session.beginTransaction();
            String sql = "SELECT * FROM employees e JOIN users u ON e.`user` = u.username WHERE u.username = '"+username+"' AND u.password = '"+password+"'";
            List<Object[]> list = session.createNativeQuery(sql, Object[].class).getResultList();
            Employee employee = findByID(Employee.class, list.get(0)[0]).get();
            tr.commit();
            return employee;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e.getMessage());
            tr.rollback();
        }
        return null;
    }
}