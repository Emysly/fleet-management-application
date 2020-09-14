package com.emysilva.fleet.management.application;

import com.emysilva.fleet.management.application.model.User;
import com.emysilva.fleet.management.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping({"/", "index"})
    public String getHome() {
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
