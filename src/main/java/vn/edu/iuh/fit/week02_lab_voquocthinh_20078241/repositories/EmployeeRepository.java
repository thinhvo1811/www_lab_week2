package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Order;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository extends GenericCRUD<Employee>{
    SessionFactory sessionFactory = MySessionFactory.getInstance().getSessionFactory();
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
}