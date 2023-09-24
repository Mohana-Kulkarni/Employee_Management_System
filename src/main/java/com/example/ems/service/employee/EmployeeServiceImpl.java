package com.example.ems.service.employee;

import com.example.ems.entity.Employee;
import com.example.ems.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) repository.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return (Page<Employee>) this.repository.findAll(pageable);
    }
}
