package com.example.demo.controller;

import com.example.demo.domain.Restaurant;
import com.example.demo.repo.RestaurantRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private final RestaurantRepo repo;

    public HomeController(RestaurantRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/rests")
    List<Restaurant> index(){
        return repo.findAll();
    }
}
