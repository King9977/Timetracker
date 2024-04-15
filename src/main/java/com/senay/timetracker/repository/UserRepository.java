package com.senay.timetracker.repository;

import com.senay.timetracker.entity.User_Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User_Task, Long> {
}