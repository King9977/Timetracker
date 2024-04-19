package ch.kayasenay.timetracker.repository;

import ch.kayasenay.timetracker.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}