package com.testjpa.service;

import com.testjpa.entity.Roles;
import com.testjpa.entity.Users;
import com.testjpa.repo.BlogMetaRepo;
import com.testjpa.repo.RolesRepo;
import com.testjpa.repo.UserRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Disabled
class ServiceDaoImplTest {

    @Mock private UserRepo userRepo;
    @Mock private RolesRepo rolesRepo;
    @Mock private BlogMetaRepo blogMetaRepo;
    @Mock private UserDetails userDetails;
    private ServiceDaoImpl serviceDao;

    @BeforeEach
    void setUp(){
        serviceDao = new ServiceDaoImpl(userRepo, blogMetaRepo, rolesRepo);
    }

    @Test
    @Disabled
    void saveBlog() {
    }

/*    @Test

    void testGetUsers() {
        serviceDao.getUsers();
        verify(userRepo).findAll();
    }
*/
    @Test
    void testSaveRole() {
        //given
        String name = "ROLE_USER";
        Roles roles = new Roles(name);

        //when
        serviceDao.saveRole(roles);

        //then
        ArgumentCaptor<Roles> rolesArgumentCaptor = ArgumentCaptor.forClass(Roles.class);

        verify(rolesRepo).save(rolesArgumentCaptor.capture());
        Roles capturedRole = rolesArgumentCaptor.getValue();
        assertThat(capturedRole).isEqualTo(roles);
    }

    @Test
    void testIfRoleExistsModule() {

        String name = "ROLE_USER";
        Roles roles = new Roles(name);

        given(rolesRepo.findByName(roles.getName())).willReturn(roles);

        assertThatThrownBy(() -> serviceDao.saveRole(roles))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Role already exists!");
    }

    @Test
    @Disabled
    void addRoleToUser() {
    }

    @Test
    @Disabled
    void testLoadUserByUsername() {
        //given
        //String username = "naruto";
        Users users = new Users("naruto", "naruto", "uzumaki",
                "hinata", "naruto@konoha.com");
        userRepo.save(users);
        //when
        //serviceDao.loadUserByUsername(users.getUsername());

        //ArgumentCaptor<Users> captor = ArgumentCaptor.forClass(Users.class);

        //verify(userRepo).findByUsername(users.getUsername());

        when(userRepo.findByUsername(users.getUsername())).thenReturn(users);
        //assertThat(userRepo.findByUsername(users.getUsername())).isEqualTo(users.getUsername());

        assertThat(serviceDao.loadUserByUsername(users.getUsername())).isEqualTo(userDetails);
    }
}