package vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.impl;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.models.Employee;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.repositories.EmployeeRepository;
import vn.edu.iuh.fit.week02_lab_voquocthinh_20078241.services.EmployeeService;

import java.util.List;
import java.util.Optional;

//public class EmployeeServiceImpl implements EmployeeService {
//    private EmployeeRepository employeeRepository;
//    public EmployeeServiceImpl() {
//        employeeRepository = new EmployeeRepository();
//    }
//    @Override
//    public boolean insert(Employee employee) {
//        return employeeRepository.insert(employee);
//    }
//
//    @Override
//    public boolean update(Employee employee) {
//        return employeeRepository.update(employee);
//    }
//
//    @Override
//    public boolean delete(long id) {
//        Optional<Employee> op = findByID(id);
//        if (op.isPresent()) {
//            Employee employee = op.get();
//            employee.setStatus(EmployeeStatus.TERMINATED);
//            return true;
//        }
//        return false;
//
//    }
//
//    @Override
//    public boolean activeEmp(long id) {
//        Optional<Employee> op = findByID(id);
//        if (op.isPresent()) {
//            Employee employee = op.get();
//            employee.setStatus(EmployeeStatus.ACTIVE);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Optional<Employee> findByID(long id) {
//        return employeeRepository.findByID(Employee.class, id);
//    }

//    @Override
//    public List<Employee> getAll() {
//        return employeeRepository.getAll();
//    }
//}
