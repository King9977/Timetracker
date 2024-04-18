package com.senay.timetracker.restController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingControllers {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUserController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testProjectController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/projects"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testTaskController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testTimeEntryController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/time-entries"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testOAuthSessionController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/oauth-sessions"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
