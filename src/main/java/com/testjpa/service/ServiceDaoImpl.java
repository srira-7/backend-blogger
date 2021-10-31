package com.testjpa.service;

import com.testjpa.repo.BlogRepo;
import com.testjpa.repo.RolesRepo;
import com.testjpa.repo.UserRepo;
import com.testjpa.entity.Blog;
import com.testjpa.entity.Roles;
import com.testjpa.entity.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ServiceDaoImpl implements ServiceDao, UserDetailsService {
    UserRepo userRepo;
    BlogRepo blogRepo;
    RolesRepo rolesRepo;

    public ServiceDaoImpl(UserRepo userRepo, BlogRepo blogRepo, RolesRepo rolesRepo) {
        this.userRepo = userRepo;
        this.blogRepo = blogRepo;
        this.rolesRepo = rolesRepo;
    }

/*
    public Users saveUser(Users user){
        return userRepo.save(user);
    }
*/

    public Blog saveBlog(Blog blog){
        return blogRepo.save(blog);
    }

    @Override
    public List<Users> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public Roles saveRole(Roles role) {
        return rolesRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Users users = userRepo.findByUsername(username);
        Roles roles = rolesRepo.findByName(roleName);
        users.getRoles().add(roles);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        log.info("username is: {}", username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserService(user);
    }

}
