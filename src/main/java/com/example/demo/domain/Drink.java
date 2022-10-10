package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Drink {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private String description;
    private Double price;
    private Double priceOfBottle;
    private Double volume;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
