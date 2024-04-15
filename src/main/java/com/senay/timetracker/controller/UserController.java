package com.senay.timetracker.controller;

import com.senay.timetracker.entity.User_Task;
import com.senay.timetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User_Task> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User_Task createUser(@RequestBody User_Task user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User_Task getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
