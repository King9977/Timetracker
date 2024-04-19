package com.senay.timetracker.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senay.timetracker.entity.User_Task;
import com.senay.timetracker.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;


import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@AutoConfigureDataJpa
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTest {

    @Autowired
    private MockMvc api;

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    void setup() {
        this.userRepository.save(new User_Task("kaya.senay", "kaya@test.ch", "Halloking1234!", 1L));
        this.userRepository.save(new User_Task("kaya.senaysolutions", "kaya.senay@senaysolutions.ch", "Halloking1234!", 2L));
    }

    @Test
    @Order(1)
    void testGetUser() throws Exception {
        String accessToken = obtainAccessToken();
        api.perform(get("/api/user").header("Authorization", "Bearer " + accessToken)
                        .with(csrf()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("kaya.senay")));
    }

    @Test
    @Order(2)
    void testGetUserById() throws Exception{
        String accessToken = obtainAccessToken();

        this.userRepository.findAll();
        List<User_Task> userList = userRepository.findAll();

        User_Task firstUser = userList.get(2);
        Long id = firstUser.getId();

        api.perform(get("/api/user/" + id).header("Authorization", "Bearer " + accessToken)
                        .with(csrf()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("kaya.senay")));
    }

    @Test
    @Order(3)
    void testNewUser() throws Exception {
        String accessToken = obtainAccessToken();
        User_Task user = new User_Task("kayaUser", "kayaUser@test.ch", "Halloking1234!", 3L);
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);

        api.perform(post("/api/user")
                        .header("Authorization", "Bearer " + accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson)
                        .with(csrf()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    void testDeleteUser() throws Exception{
        String accessToken = obtainAccessToken();

        api.perform(delete("/api/user/1")
                        .header("Authorization", "Bearer " + accessToken).with(csrf()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(5)
    void testSaveUser() throws Exception {

        User_Task userTask = new User_Task();

        userTask.setUsername("kaya.senay");
        userTask.setEmail("kayaslala1@hotmail.com");
        userTask.setPasswordHash("Halloking1234!");

        String accessToken = obtainAccessToken();
        String body = new ObjectMapper().writeValueAsString(userTask);

        api.perform(post("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        .header("Authorization", "Bearer " + accessToken)
                        .with(csrf()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("kaya.senay")));
    }

    private String obtainAccessToken() {

        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String body = "client_id=timetrackerapp&" +
                "grant_type=password&" +
                "scope=openid profile roles offline_access&" +
                "username=admin&" +
                "password=Halloking1234!";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> resp = rest.postForEntity("http://localhost:8080/realms/timetracker/protocol/openid-connect/token", entity, String.class);

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resp.getBody()).get("access_token").toString();
    }
}

