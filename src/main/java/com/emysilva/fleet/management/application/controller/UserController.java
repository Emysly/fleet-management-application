package com.emysilva.fleet.management.application.controller;

import com.emysilva.fleet.management.application.model.Country;
import com.emysilva.fleet.management.application.model.User;
import com.emysilva.fleet.management.application.service.CountryService;
import com.emysilva.fleet.management.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/users/findById")
    @ResponseBody
    public User getUser(int id) {
        return userService.getUser(id);
    }

    @PostMapping("/users/addNew")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/users/update", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String deleteUser(int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
