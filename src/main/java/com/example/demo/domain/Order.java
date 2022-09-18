package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Order { //todo: add relations
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Restaurant restaurant;
    private User client;
    private TableInRestaurant seatNumber;
    private Employee worksWith; //todo: set of pipeline employees

}
