package com.senay.timetracker.datenbank;

import com.senay.timetracker.entity.Role;
import com.senay.timetracker.repository.RoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class DBTestsRole {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void insertRole() {
        Role roleA = new Role();
        roleA.setName("Admin");
        Role savedRoleA = this.roleRepository.save(roleA);
        Assertions.assertNotNull(savedRoleA.getId());

        Role roleB = new Role();
        roleB.setName("User");
        Role savedRoleB = this.roleRepository.save(roleB);
        Assertions.assertNotNull(savedRoleB.getId());
    }
}
