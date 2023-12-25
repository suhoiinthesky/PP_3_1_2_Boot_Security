package ru.kata.spring.boot_security.demo.Service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
public interface UserService {
    void save(User user);
    List<User> getUserList();
    void delete(User user);
    User findById(Long id);
}
