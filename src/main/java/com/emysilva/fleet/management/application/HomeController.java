package com.emysilva.fleet.management.application;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.Employee;
import com.emysilva.fleet.management.application.model.User;
import com.emysilva.fleet.management.application.model.Vehicle;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.EmployeeService;
import com.emysilva.fleet.management.application.service.UserService;
import com.emysilva.fleet.management.application.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CountryService countryService;

    @GetMapping({"/", "index"})
    public String getHome(Model model) {
        List<Vehicle> vehicles = vehicleService.getVehicles();
        List<Employee> employees = employeeService.getEmployees();
        List<Country> countries = countryService.getCountries();
        model.addAttribute("vehicles", vehicles);
        model.addAttribute("employees", employees);
        model.addAttribute("countries", countries);
        return "index";
    }

    @GetMapping("/blank")
    public String blank() {
        return "blank";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register/user")
    public RedirectView addUser(User user, RedirectAttributes redirectAttributes) {
        userService.addUser(user);
        RedirectView redirectView = new RedirectView("/login", true);
        redirectAttributes.addFlashAttribute("message", "You have successfully registered, You can now login");
        return redirectView;
    }
}
