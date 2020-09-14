package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.Employee;
import com.emysilva.fleet.management.application.model.User;
import com.emysilva.fleet.management.application.repository.ClientRepository;
import com.emysilva.fleet.management.application.repository.EmployeeRepository;
import com.emysilva.fleet.management.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NoSuchDataException("employee with id: " + id + "not found"));
    }

    public void deleteEmployee(int id) {
        Employee employeeToDelete = employeeRepository.findById(id).orElseThrow(() -> new NoSuchDataException("employee with id: " + id + "not found"));
        employeeRepository.delete(employeeToDelete);
    }

    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

}
