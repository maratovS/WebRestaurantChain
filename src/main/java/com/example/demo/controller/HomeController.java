package com.example.demo.controller;

import com.example.demo.domain.Restaurant;
import com.example.demo.domain.User;
import com.example.demo.repo.RestaurantRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
    private final UserRepo repo;

    public HomeController(UserRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/rests")
    List<User> index(){
        return repo.findAll();
    }
}
