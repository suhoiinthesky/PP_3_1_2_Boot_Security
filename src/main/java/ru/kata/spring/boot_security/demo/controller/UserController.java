package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.Service.UserServiceIpm;
import ru.kata.spring.boot_security.demo.model.User;


import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceIpm userService;

    public UserController(UserServiceIpm userService) {
        this.userService = userService;
    }
    @GetMapping
    public String getUserPage(Model model, Principal principal) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "userPage/user";
    }
}
