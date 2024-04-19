package ch.kayasenay.timetracker.controller;

import ch.kayasenay.timetracker.entity.Project;
import ch.kayasenay.timetracker.service.ProjectService;
import ch.kayasenay.timetracker.security.Roles;
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
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("api/project")
    @RolesAllowed(Roles.Read)
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping("api/project")
    @RolesAllowed(Roles.Admin)
    public Project createProject(@Valid @RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping("api/project/{id}")
    @RolesAllowed(Roles.Read)
    public Project getProjectById(@Valid @PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PutMapping("api/project/{id}")
    @RolesAllowed(Roles.Admin)
    public Project updateProject(@Valid @PathVariable Long id, @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("api/project/{id}")
    @RolesAllowed(Roles.Admin)
    public void deleteProject(@Valid @PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
