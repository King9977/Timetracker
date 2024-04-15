package com.senay.timetracker.service;

import com.senay.timetracker.entity.OAuthSession;
import com.senay.timetracker.repository.OAuthSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OAuthSessionService {
    @Autowired
    private OAuthSessionRepository oAuthSessionRepository;

    public List<OAuthSession> getAllOAuthSessions() {
        return oAuthSessionRepository.findAll();
    }

    public OAuthSession createOAuthSession(OAuthSession oAuthSession) {
        return oAuthSessionRepository.save(oAuthSession);
    }

    public OAuthSession getOAuthSessionById(Long id) {
        return oAuthSessionRepository.findById(id).orElse(null);
    }

    public void deleteOAuthSession(Long id) {
        oAuthSessionRepository.deleteById(id);
    }
}
