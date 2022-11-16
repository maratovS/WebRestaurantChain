package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private String description;
    private Double price;
    private Double weight;
    private Double calories;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
