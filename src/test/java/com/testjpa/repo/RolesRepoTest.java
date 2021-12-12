package com.testjpa.repo;

import com.testjpa.entity.Roles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RolesRepoTest {

    @Autowired
    private RolesRepo rolesRepo;

    @Test
    void findByName() {
        String name = "ROLE_USER";
        Roles roles = new Roles(name);
        rolesRepo.save(roles);

        Roles exists = rolesRepo.findByName(roles.getName());

        assertThat(exists).isEqualTo(roles);
    }
}