package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.*;
import com.emysilva.fleet.management.application.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
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

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeService.getEmployees();
        List<JobTitle> jobTitles = jobTitleService.getJobTitles();
        List<Country> countries = countryService.getCountries();
        List<State> states = stateService.getStates();
        List<EmployeeType> employeeTypes = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employees", employees);
        model.addAttribute("jobTitles", jobTitles);
        model.addAttribute("countries", countries);
        model.addAttribute("states", states);
        model.addAttribute("employeeTypes", employeeTypes);
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
