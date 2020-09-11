package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.Employee;
import com.emysilva.fleet.management.application.service.ClientService;
import com.emysilva.fleet.management.application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "employee";
    }

    @GetMapping("/employees/findById")
    @ResponseBody
    public Employee getEmployee(int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees/addNew")
    public String addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateEmployee(Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/delete")
    public String deleteEmployee(int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
