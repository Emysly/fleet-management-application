package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Client;
import com.emysilva.fleet.management.application.model.Employee;
import com.emysilva.fleet.management.application.model.EmployeeType;
import com.emysilva.fleet.management.application.service.ClientService;
import com.emysilva.fleet.management.application.service.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeTypeController {
    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeTypes")
    public String getEmployeeTypes(Model model) {
        List<EmployeeType> employeeTypes = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypes);
        return "employeetype";
    }

    @GetMapping("/employeeTypes/findById")
    @ResponseBody
    public EmployeeType getEmployeeType(int id) {
        return employeeTypeService.getEmployeeType(id);
    }

    @PostMapping("/employeeTypes/addNew")
    public String addEmployeeType(EmployeeType employeeType) {
        employeeTypeService.addEmployeeType(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value = "/employeeTypes/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateEmployeeType(EmployeeType employeeType) {
        employeeTypeService.addEmployeeType(employeeType);
        return "redirect:/employeeTypes";
    }

    @GetMapping("/employeeTypes/delete")
    public String deleteEmployeeType(int id) {
        employeeTypeService.deleteEmployeeType(id);
        return "redirect:/employeeTypes";
    }
}
