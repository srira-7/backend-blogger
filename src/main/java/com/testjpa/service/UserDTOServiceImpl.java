package com.testjpa.service;

import com.testjpa.repo.UserRepo;
import com.testjpa.entity.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDTOServiceImpl implements UserDTOService{
    UserRepo userRepo;
    //    Users users;
    PasswordEncoder passwordEncoder;

    public UserDTOServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
    //    this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Users getUsers(String username) {
        return userRepo.findByUsername(username);
    }

    public Users registerUser(UserDTO userDTO){
        if(emailExists(userDTO.getEmailID()) && usernameExists(userDTO.getUsername())){
            throw new RuntimeException("User already exists!");
        }

        return userRepo.save(new Users(userDTO.getUsername(),
                            userDTO.getFirstName(),
                            userDTO.getLastName(),
                            passwordEncoder.encode(userDTO.getPassword()),
                            userDTO.getEmailID()));
        }

       /* users.setUsername(userDTO.getUsername());
        users.setFirstName(userDTO.getFirstName());
        users.setLastName(userDTO.getLastName());
        users.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        users.setEmailID(userDTO.getEmailID());

        return userRepo.save(users);*/

    public boolean emailExists(String email){
        return userRepo.findByEmailID(email) != null;
    }

    public boolean usernameExists(String username) { return userRepo.findByUsername(username) != null; }
}
