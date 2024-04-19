package ch.kayasenay.timetracker.controller;

import ch.kayasenay.timetracker.entity.TimeEntry;
import ch.kayasenay.timetracker.security.Roles;
import ch.kayasenay.timetracker.service.TimeEntryService;
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
public class TimeEntryController {
    @Autowired
    private TimeEntryService timeEntryService;

    @GetMapping("api/timeEntry")
    @RolesAllowed(Roles.Read)
    public List<TimeEntry> getAllTimeEntries() {
        return timeEntryService.getAllTimeEntries();
    }

    @PostMapping("api/timeEntry")
    @RolesAllowed(Roles.Admin)
    public TimeEntry createTimeEntry(@Valid @RequestBody TimeEntry timeEntry) {
        return timeEntryService.createTimeEntry(timeEntry);
    }

    @GetMapping("api/timeEntry/{id}")
    @RolesAllowed(Roles.Read)
    public TimeEntry getTimeEntryById(@Valid @PathVariable Long id) {
        return timeEntryService.getTimeEntryById(id);
    }

    @PutMapping("api/timeEntry/{id}")
    @RolesAllowed(Roles.Admin)
    public TimeEntry updateTimeEntry(@Valid @PathVariable Long id, @RequestBody TimeEntry timeEntry) {
        return timeEntryService.updateTimeEntry(id, timeEntry);
    }

    @DeleteMapping("/timeEntry/{id}")
    @RolesAllowed(Roles.Admin)
    public void deleteTimeEntry(@Valid @PathVariable Long id) {
        timeEntryService.deleteTimeEntry(id);
    }
}
