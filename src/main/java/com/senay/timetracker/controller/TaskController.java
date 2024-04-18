package com.senay.timetracker.controller;

import com.senay.timetracker.entity.Task;
import com.senay.timetracker.security.Roles;
import com.senay.timetracker.service.TaskService;
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
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("api/task")
    @RolesAllowed(Roles.Read)
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("api/task")
    @RolesAllowed(Roles.Admin)
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("api/task/{id}")
    @RolesAllowed(Roles.Read)
    public Task getTaskById(@Valid @PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("api/task/{id}")
    @RolesAllowed(Roles.Admin)
    public Task updateTask(@Valid @PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("api/task/{id}")
    @RolesAllowed(Roles.Admin)
    public void deleteTask(@Valid @PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
