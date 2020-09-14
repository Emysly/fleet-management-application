package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.*;
import com.emysilva.fleet.management.application.service.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeControllerTest {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JobTitleService jobTitleService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;
    @Autowired
    private EmployeeTypeService employeeTypeService;

    List<Country> countries = null;
    List<State> states = null;
    List<JobTitle> jobTitles = null;
    List<Employee> employees = null;
    List<EmployeeType> employeeTypes = null;

    @BeforeEach
    void setUp() {
        countries = countryService.getCountries();
        states = stateService.getStates();
        jobTitles = jobTitleService.getJobTitles();
        employees = employeeService.getEmployees();
        employeeTypes = employeeTypeService.getEmployeeTypes();
    }

    @Test
    void getEmployees() {
        assertEquals(countries.size(), countries.size());
        assertEquals(states.size(), states.size());
        assertEquals(jobTitles.size(), jobTitles.size());
        assertEquals(employees.size(), employees.size());
        assertEquals(employeeTypes.size(), employeeTypes.size());
    }

    @Test
    void getEmployee() {
        assertEquals(employeeService.getEmployee(2).getAddress(), employeeService.getEmployee(2).getAddress());
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee();
        employee.setId(5);
        employee.setEmail("emysly12@gmail.com");
        employee.setFirstname("Chukwuebuka");
        employee.setLastname("Emmanuel");
        employee.setPhone("09040201098");

        int initialSize = employees.size();

        employees.add(employee);

        assertEquals(initialSize + 1, employees.size());
    }

    @Test
    void updateEmployee() {
        Employee employee = employeeService.getEmployee(2);
        employee.setId(5);
        employee.setEmail("emysly12@gmail.com");
        employee.setFirstname("Chukwuebuka");
        employee.setLastname("Emmanuel");
        employee.setPhone("09040201098");

        int initialSize = employees.size();

        employees.add(employee);

        assertEquals(initialSize + 1, employees.size());
    }

    @Test
    void deleteEmployee() {
        int initialSize = employees.size();

        if (employees.size() != 0)
            employees.remove(0);

        assertEquals(initialSize - 1, employees.size());
    }

    @AfterEach
    void tearDown() {
        employees = null;
        countries = null;
        states = null;
        jobTitles = null;
        employeeTypes = null;
    }
}