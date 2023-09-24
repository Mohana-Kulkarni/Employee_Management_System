package com.example.ems.dao.employee;

import com.example.ems.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("select * from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Employee employee = entityManager.find(Employee.class, id);
        if(employee == null) {
            return null;
        }
        return employee;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        String[] arr = name.split(" ");
        String firstName = arr[0];
        String lastName = arr[1];
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e " +
                "where e.first_name = :firstName && e.last_name = :lastName", Employee.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        Employee employee = query.getSingleResult();
        if(employee == null) {
            return null;
        }
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public Employee deleteEmployeeById(long id) {
        Employee employee = entityManager.find(Employee.class, id);
        if(employee == null) {
            return null;
        }
        entityManager.remove(employee);
        return employee;
    }


}
