package com.testjpa.service;

import com.testjpa.entity.Blog;
import com.testjpa.entity.Roles;
import com.testjpa.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceDao {
//    public Users saveUser(Users user);
    public Blog saveBlog(Blog blog);
    public List<Users> getUsers();
    public Roles saveRole(Roles role);
    public void addRoleToUser(String username, String roleName);
}
