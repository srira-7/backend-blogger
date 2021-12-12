package com.testjpa.service;

import com.testjpa.entity.BlogMeta;
import com.testjpa.repo.BlogMetaRepo;
import com.testjpa.repo.RolesRepo;
import com.testjpa.repo.UserRepo;
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
    BlogMetaRepo blogMetaRepo;
    RolesRepo rolesRepo;

    public ServiceDaoImpl(UserRepo userRepo, BlogMetaRepo blogMetaRepo, RolesRepo rolesRepo) {
        this.userRepo = userRepo;
        this.blogMetaRepo = blogMetaRepo;
        this.rolesRepo = rolesRepo;
    }

/*    //for unit testing without using blogRepo as blog isn't implemented yet
    public ServiceDaoImpl(UserRepo userRepo, RolesRepo rolesRepo) {
        this.userRepo = userRepo;
        this.rolesRepo = rolesRepo;
    }*/
/*
    public Users saveUser(Users user){
        return userRepo.save(user);
    }
*/

    public BlogMeta saveBlog(BlogMeta blogMeta){

        return blogMetaRepo.save(blogMeta);
    }

   /* @Override
    public BlogDTO savePost() {
        return ;
    }*/

    @Override
    public Roles saveRole(Roles role) {

        String roleName = role.getName();
        if (rolesRepo.findByName(roleName) == role) {
            throw new RuntimeException("Role already exists!");
        }

        return rolesRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Users users = userRepo.findByUsername(username);
        Roles roles = rolesRepo.findByName(roleName);
        users.getRoles().add(roles);
    }

    @Override
    public List<BlogMeta> getAllBlogs() {
        return blogMetaRepo.findAll();
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

    @Override
    public List<BlogMeta> getBlogByUser(String username) {

    //    Users users = userRepo.findByUsername(username);
    //    Integer userId = users.getId();
        return blogMetaRepo.findBlogByUser(username);
    }

    @Override
    public List<BlogMeta> getBlogBySearch(String keyword) {
        return blogMetaRepo.findBlogBySearch(keyword);
    }
}
