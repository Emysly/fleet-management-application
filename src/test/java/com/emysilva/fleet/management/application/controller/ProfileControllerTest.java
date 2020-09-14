package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProfileControllerTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void findByUsername() {
        assertNull(employeeService.findByUsername("emysilva"));
    }
}