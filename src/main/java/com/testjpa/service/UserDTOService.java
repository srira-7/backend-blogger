package com.testjpa.service;

import com.testjpa.entity.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserDTOService {
    public Users registerUser(UserDTO userDTO);
    public Users getUsers(String username);
}
