package com.emysilva.fleet.management.application.service;

import com.emysilva.fleet.management.application.exception.NoSuchDataException;
import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.EmployeeType;
import com.emysilva.fleet.management.application.repository.ClientRepository;
import com.emysilva.fleet.management.application.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    public List<EmployeeType> getEmployeeTypes() {
        return employeeTypeRepository.findAll();
    }

    public void addEmployeeType(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    public EmployeeType getEmployeeType(int id) {
        return employeeTypeRepository.findById(id).orElseThrow(() -> new NoSuchDataException("employee type with id: " + id + "not found"));
    }

    public void deleteEmployeeType(int id) {
        EmployeeType employeeTypeToDelete = employeeTypeRepository.findById(id).orElseThrow(() -> new NoSuchDataException("employee type with id: " + id + "not found"));
        employeeTypeRepository.delete(employeeTypeToDelete);
    }
}
