package com.example.ems.dao.employee;

import com.example.ems.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee getEmployeeByName(String name);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    Employee deleteEmployeeById(long id);


}
