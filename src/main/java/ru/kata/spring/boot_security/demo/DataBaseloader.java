package ru.kata.spring.boot_security.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.Service.RoleServiceImp;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.Service.UserServiceIpm;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.HashSet;
import java.util.List;

@Component
public class DataBaseloader implements CommandLineRunner {
    private final UserService userService;
    private final RoleServiceImp roleService;

    public DataBaseloader(UserService userService, RoleServiceImp roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        Role ROLE_USER = new Role("ROLE_USER");
        roleService.save(ROLE_USER);

        Role ROLE_ADMIN = new Role("ROLE_ADMIN");
        roleService.save(ROLE_ADMIN);

        User user = new User("userAbuser", "fafi@gmail.ru", "1234");
        user.setRoles(new HashSet<>(List.of(ROLE_USER)));
        userService.save(user);

        User admin = new User("Admin", "joja@gmail.ru", "123456");
        admin.setRoles(new HashSet<>(List.of(ROLE_ADMIN, ROLE_USER)));
        userService.save(admin);


    }
}
