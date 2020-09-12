package com.emysilva.fleet.management.application;

import com.emysilva.fleet.management.application.model.User;
import com.emysilva.fleet.management.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping({"/", "index"})
    public String getHome() {
        return "index";
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
    public String addUser(@Valid User user) {
        userService.addUser(user);
        return "redirect:/login";
    }
}
