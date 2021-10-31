package com.testjpa.controller;

import com.testjpa.service.ServiceDao;
import com.testjpa.service.UserDTO;
import com.testjpa.service.UserDTOServiceImpl;
import com.testjpa.entity.Blog;
import com.testjpa.entity.Roles;
import com.testjpa.entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    ServiceDao serviceDao;
    UserDTOServiceImpl userDTOService;

    public Controller(ServiceDao serviceDao, UserDTOServiceImpl userDTOService) {
        this.serviceDao = serviceDao;
        this.userDTOService = userDTOService;
    }

    @GetMapping("/user/getusers")
    public ResponseEntity<List<Users>> getUsers(){
        return ResponseEntity.ok().body(serviceDao.getUsers());
    }

    @PostMapping("/user/registeruser")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok().body(userDTOService.registerUser(userDTO));
    }

    @PostMapping("/blog/saveblog")
    public ResponseEntity<Blog> saveUser(@RequestBody Blog blog){
        return ResponseEntity.ok().body(serviceDao.saveBlog(blog));
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
}
