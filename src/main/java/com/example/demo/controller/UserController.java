package com.example.demo.controller;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/getRoles")
    List<Role> getRoles(){
        return userService.getRoles();
    }

    @GetMapping("/getUsers")
    List<User> getUsers(){
        return userService.getUsers();
    }
}
