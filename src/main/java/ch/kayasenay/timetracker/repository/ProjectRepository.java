package ch.kayasenay.timetracker.repository;

import ch.kayasenay.timetracker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}