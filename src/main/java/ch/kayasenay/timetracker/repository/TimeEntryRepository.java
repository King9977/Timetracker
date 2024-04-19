package ch.kayasenay.timetracker.repository;

import ch.kayasenay.timetracker.entity.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
}