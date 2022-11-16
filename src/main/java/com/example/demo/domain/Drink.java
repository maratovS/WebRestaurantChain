package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
