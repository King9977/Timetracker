package ch.kayasenay.timetracker.datenbank;

import ch.kayasenay.timetracker.repository.UserRepository;
import ch.kayasenay.timetracker.entity.User_Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class DBTestsUser {

    @Autowired
    private UserRepository userRepository;

    @Test
    void userTests() {
        User_Task objUser1 = this.userRepository.save(new User_Task("kaya.senay", "kayaslala1@hotmail.com", "Halloking1234!", 1L));
        Assertions.assertNotNull(objUser1.getId());

        User_Task objUser2 = this.userRepository.save(new User_Task("amy.hübschi", "kaya.senay@senaysolutions.ch", "Halloking1234!", 1L));
        Assertions.assertNotNull(objUser2.getId());
    }
}
