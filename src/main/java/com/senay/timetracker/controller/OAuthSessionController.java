package com.senay.timetracker.controller;

import com.senay.timetracker.entity.OAuthSession;
import com.senay.timetracker.service.OAuthSessionService;
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
    public OAuthSession createOAuthSession(@RequestBody OAuthSession oAuthSession) {
        return oAuthSessionService.createOAuthSession(oAuthSession);
    }

    @GetMapping("/{id}")
    public OAuthSession getOAuthSessionById(@PathVariable Long id) {
        return oAuthSessionService.getOAuthSessionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOAuthSession(@PathVariable Long id) {
        oAuthSessionService.deleteOAuthSession(id);
    }
}