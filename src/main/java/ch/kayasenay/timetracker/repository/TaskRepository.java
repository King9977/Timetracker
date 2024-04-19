package ch.kayasenay.timetracker.repository;

import ch.kayasenay.timetracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}