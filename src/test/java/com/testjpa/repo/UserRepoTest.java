package com.testjpa.repo;

import com.testjpa.entity.Users;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepoTest {

    @Autowired
    UserRepo userRepo;
    PasswordEncoder passwordEncoder;

    @Test
    void findByUsername() {

        Users users = new Users("naruto", "naruto", "uzumaki",
                "hinata", "naruto@konoha.com");
        userRepo.save(users);

        Users exists = userRepo.findByUsername(users.getUsername());

        assertThat(exists).isEqualTo(users);
    }

    @Test
    void findByEmailID() {
        Users users = new Users("naruto", "naruto", "uzumaki",
                "hinata", "naruto@konoha.com");
        userRepo.save(users);

        Users exists = userRepo.findByEmailID(users.getEmailID());

        assertThat(exists).isEqualTo(users);
    }
}