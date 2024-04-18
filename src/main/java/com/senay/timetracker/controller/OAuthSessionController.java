package com.senay.timetracker.controller;

import com.senay.timetracker.entity.OAuthSession;
import com.senay.timetracker.service.OAuthSessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oauth-sessions")
public class OAuthSessionController {
    @Autowired
    private OAuthSessionService oAuthSessionService;

    @GetMapping
    public List<OAuthSession> getAllOAuthSessions() {
        return oAuthSessionService.getAllOAuthSessions();
    }

    @PostMapping
    public OAuthSession createOAuthSession(@Valid @RequestBody OAuthSession oAuthSession) {
        return oAuthSessionService.createOAuthSession(oAuthSession);
    }

    @GetMapping("/{id}")
    public OAuthSession getOAuthSessionById(@Valid @PathVariable Long id) {
        return oAuthSessionService.getOAuthSessionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOAuthSession(@Valid @PathVariable Long id) {
        oAuthSessionService.deleteOAuthSession(id);
    }
}