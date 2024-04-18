package com.senay.timetracker.datenbank;


import com.senay.timetracker.entity.User_Task;
import com.senay.timetracker.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class DatenbankTestUserRepository {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserCRUDOperations() {
        // Create
        User_Task user = new User_Task();
        user.setUsername("kaya_senay");
        user.setEmail("kaya.senay@senaysolutions.com");
        user.setPasswordHash("Halloking1234!");
        user.setRoleId(1L);
        userRepository.save(user);
        assertNotNull(user.getId(), "User ID should not be null after saving.");

        // Read
        User_Task savedUser = userRepository.findById(user.getId()).orElse(null);
        assertNotNull(savedUser, "Saved user should not be null.");
        assertEquals("kaya_senay", savedUser.getUsername(), "Username should match.");
        assertEquals("kaya.senay@senaysolutions.com", savedUser.getEmail(), "Email should match.");
        assertEquals("Halloking1234!", savedUser.getPasswordHash(), "Password hash should match.");
        assertEquals(1L, savedUser.getRoleId(), "Role ID should match.");

        // Update
        savedUser.setUsername("kaya.senay");
        userRepository.save(savedUser);
        User_Task updatedUser = userRepository.findById(savedUser.getId()).orElse(null);
        assertNotNull(updatedUser, "Updated user should not be null.");
        assertEquals("kaya.senay", updatedUser.getUsername(), "Username should be updated.");

        // Delete
        userRepository.delete(updatedUser);
        User_Task deletedUser = userRepository.findById(updatedUser.getId()).orElse(null);
        assertNull(deletedUser, "Deleted user should be null.");
    }
}
