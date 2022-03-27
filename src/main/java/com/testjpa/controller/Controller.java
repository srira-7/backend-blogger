package com.testjpa.controller;

import com.testjpa.entity.*;
import com.testjpa.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@Validated
public class Controller {

    @Autowired
    ServiceDao serviceDao;

    @Autowired
    UserDTOService userDTOService;

    Authentication authentication;

    public Controller(){}

    /*public Controller(ServiceDao serviceDao, UserDTOService userDTOService) {
        this.serviceDao = serviceDao;
        this.userDTOService = userDTOService;
    }*/

    public Controller(ServiceDao serviceDao,
                      UserDTOService userDTOService,
                      Authentication authentication) {
        this.serviceDao = serviceDao;
        this.userDTOService = userDTOService;
        this.authentication = authentication;
    }

    /* @GetMapping("/user/getusers")
    public ResponseEntity<Users> getUsers(){
        return ResponseEntity.ok().body(serviceDao.getUsers());
    }
    */

    @PostMapping("/user/registeruser")
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserDTO userDTO){
        return ResponseEntity.ok().body(userDTOService.registerUser(userDTO));
    }

    @PostMapping("/user/saverole")
    public ResponseEntity<Roles> saveRole(@RequestBody Roles roles){
        return ResponseEntity.ok().body(serviceDao.saveRole(roles));
    }

    @PostMapping("/user/addroletouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        serviceDao.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/blog/saveblog")
    public ResponseEntity<BlogMeta> saveBlog(@RequestBody BlogMeta blogMeta){
        BlogContent blogContent = new BlogContent();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        log.info("username at saveblog: " + username);
        blogMeta.setUsers(userDTOService.getUsers(username));
        blogMeta.setPublishedDate(Date.valueOf(LocalDate.now()));
        log.info("published date: " + Date.valueOf(LocalDate.now()));
        return ResponseEntity.ok().body(serviceDao.saveBlog(blogMeta));
    }

    @GetMapping("/blog/getallblogs")
    public ResponseEntity<List<BlogMeta>> getAllBlogs(){

        return ResponseEntity.ok().body(serviceDao.getAllBlogs());
    }

    @GetMapping("/blog/getblogbyuser/{username}")
    public ResponseEntity<List<BlogMeta>> getBlogByUser(@PathVariable String username){
        return ResponseEntity.ok().body(serviceDao.getBlogByUser(username));
    }

    @GetMapping("/blog/search/{keyword}")
    public ResponseEntity<List<BlogMeta>> searchForBlogs(@PathVariable String keyword){
        return ResponseEntity.ok().body(serviceDao.getBlogBySearch(keyword));
    }
}
