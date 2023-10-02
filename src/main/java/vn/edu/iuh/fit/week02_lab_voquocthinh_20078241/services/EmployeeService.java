package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services;

import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public boolean insert(Employee employee);
    public boolean update(Employee employee);
    public boolean delete(long id);
    public boolean activeEmp(long id);
    public Optional<Employee> findByID(long id);
    public List<Employee> getAll();
    public Employee getEmployeeByEmailAndPhone(String email, String phone);
}
