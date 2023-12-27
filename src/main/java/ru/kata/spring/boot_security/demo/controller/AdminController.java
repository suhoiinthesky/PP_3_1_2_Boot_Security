package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.Service.RoleServiceImp;
import ru.kata.spring.boot_security.demo.Service.UserServiceIpm;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserServiceIpm userService;
    private final RoleServiceImp roleService;

    public AdminController(UserServiceIpm userService, RoleServiceImp roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getUsersListPage(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "adminPage/users";
    }

    @GetMapping("/showUser")
    public String findUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "adminPage/userInfo";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(userService.findById(id));
        return "redirect:/admin/home";
    }

    @GetMapping(value = "/template")
    public String getUserTemplate(@RequestParam(value = "id", required = false) Long id, Model model) {
        User user;
        if (id != null) {
            user = userService.findById(id);
        } else {
            user = new User();
        }
        List<Role> roles = roleService.getRoleList();
        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "adminPage/template";
    }
    @PostMapping
    public String UserIsAddOrUpdate(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/home";
    }
}
