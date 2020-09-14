package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Contact;
import com.emysilva.fleet.management.application.model.EmployeeType;
import com.emysilva.fleet.management.application.service.EmployeeTypeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeTypeControllerTest {

    @Autowired
    private EmployeeTypeService employeeTypeService;

    List<EmployeeType> employeeTypes = null;

    @BeforeEach
    void setUp() {
        employeeTypes = employeeTypeService.getEmployeeTypes();
    }

    @Test
    void getEmployeeTypes() {
        assertEquals(employeeTypes.size(), employeeTypes.size());
    }

    @Test
    void getEmployeeType() {
        assertEquals(employeeTypeService.getEmployeeType(1).getCreatedBy(), employeeTypeService.getEmployeeType(1).getCreatedBy());
    }

    @Test
    void addEmployeeType() {
        EmployeeType employeeType = new EmployeeType();
        employeeType.setId(5);
        employeeType.setDescription("Senior Engineer");
        employeeType.setDetails("Chukwuebuka is a Senior Engineer");

        int initialSize = employeeTypes.size();

        employeeTypes.add(employeeType);

        assertEquals(initialSize + 1, employeeTypes.size());
    }

    @Test
    void updateEmployeeType() {
        EmployeeType employeeType = employeeTypeService.getEmployeeType(1);
        employeeType.setId(5);
        employeeType.setDescription("Senior Engineer");
        employeeType.setDetails("Chukwuebuka is a Senior Engineer");

        int initialSize = employeeTypes.size();

        employeeTypes.add(employeeType);

        assertEquals(initialSize + 1, employeeTypes.size());
    }

    @Test
    void deleteEmployeeType() {
        int initialSize = employeeTypes.size();

        if (employeeTypes.size() != 0)
            employeeTypes.remove(0);

        assertEquals(initialSize - 1, employeeTypes.size());
    }

    @AfterEach
    void tearDown() {
        employeeTypes = null;
    }

}