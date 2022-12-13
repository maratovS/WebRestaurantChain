package com.example.demo.service;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getUser(String username);
    User addUser(User user);
    List<User> getUsers();
    List<Role> getRoles();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> getUnemployed();
}
