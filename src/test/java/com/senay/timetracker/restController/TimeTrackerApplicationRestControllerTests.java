package com.senay.timetracker.restController;

import com.senay.timetracker.entity.*;
import com.senay.timetracker.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class TimeTrackerApplicationRestControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private TimeEntryService timeEntryService;

	@Autowired
	private OAuthSessionService oAuthSessionService;

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

	@Test
	public void testUserService() {
		// Test für getAllUsers
		List<User_Task> userList = userService.getAllUsers();
		assertEquals(0, userList.size());

	}

	@Test
	public void testProjectService() {
		List<Project> projectList = projectService.getAllProjects();
		assertEquals(0, projectList.size());

	}

	@Test
	public void testTaskService() {
		List<Task> taskList = taskService.getAllTasks();
		assertEquals(0, taskList.size());

	}

	@Test
	public void testTimeEntryService() {
		List<TimeEntry> timeEntryList = timeEntryService.getAllTimeEntries();
		assertEquals(0, timeEntryList.size());

	}

	@Test
	public void testOAuthSessionService() {
		List<OAuthSession> oAuthSessionList = oAuthSessionService.getAllOAuthSessions();
		assertEquals(0, oAuthSessionList.size());

	}
}

