package com.senay.timetracker.controller;

import com.senay.timetracker.entity.User_Task;
import com.senay.timetracker.security.Roles;
import com.senay.timetracker.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearerAuth")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("api/user")
    @RolesAllowed(Roles.Read)
    public List<User_Task> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("api/user")
    @RolesAllowed(Roles.Admin)
    public User_Task createUser(@Valid @RequestBody User_Task user) {
        return userService.createUser(user);
    }

    @GetMapping("api/user/{id}")
    @RolesAllowed(Roles.Read)
    public User_Task getUserById(@Valid @PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("api/user/{id}")
    @RolesAllowed(Roles.Admin)
    public User_Task updateUser(@Valid @PathVariable Long id, @RequestBody User_Task user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("api/user/{id}")
    @RolesAllowed(Roles.Admin)
    public void deleteUser(@Valid @PathVariable Long id) {
        userService.deleteUser(id);
    }
}
