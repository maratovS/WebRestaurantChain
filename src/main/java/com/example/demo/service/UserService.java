package com.example.demo.service;

import com.example.demo.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User getUser(String username);
}
