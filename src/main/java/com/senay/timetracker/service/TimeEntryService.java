package com.senay.timetracker.service;

import com.senay.timetracker.entity.TimeEntry;
import com.senay.timetracker.repository.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeEntryService {
    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public List<TimeEntry> getAllTimeEntries() {
        return timeEntryRepository.findAll();
    }

    public TimeEntry createTimeEntry(TimeEntry timeEntry) {
        return timeEntryRepository.save(timeEntry);
    }

    public TimeEntry getTimeEntryById(Long id) {
        return timeEntryRepository.findById(id).orElse(null);
    }

    public void deleteTimeEntry(Long id) {
        timeEntryRepository.deleteById(id);
    }

    public TimeEntry updateTimeEntry(Long id, TimeEntry timeEntry) {
        return timeEntry;
    }
}
