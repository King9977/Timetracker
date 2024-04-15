package com.senay.timetracker.repository;

import com.senay.timetracker.entity.OAuthSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OAuthSessionRepository extends JpaRepository<OAuthSession, Long> {
}