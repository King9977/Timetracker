package com.senay.timetracker.controller;

import com.senay.timetracker.entity.TimeEntry;
import com.senay.timetracker.service.TimeEntryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    @Autowired
    private TimeEntryService timeEntryService;

    @GetMapping
    public List<TimeEntry> getAllTimeEntries() {
        return timeEntryService.getAllTimeEntries();
    }

    @PostMapping
    public TimeEntry createTimeEntry(@Valid @RequestBody TimeEntry timeEntry) {
        return timeEntryService.createTimeEntry(timeEntry);
    }

    @GetMapping("/{id}")
    public TimeEntry getTimeEntryById(@Valid @PathVariable Long id) {
        return timeEntryService.getTimeEntryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTimeEntry(@Valid @PathVariable Long id) {
        timeEntryService.deleteTimeEntry(id);
    }
}