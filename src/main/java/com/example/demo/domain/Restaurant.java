package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Long.class)
public class Restaurant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String restaurantName;
    private String address;
    private String description;
    private String kitchenSpeciality;
    private String wallpaperURL;
    @OneToMany(mappedBy = "placeOfWork")
    @ToString.Exclude
    private List<User> staff;
    @OneToMany(mappedBy = "restaurant")
    @ToString.Exclude
    private List<Order> orders;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TableInRestaurant> tables;
    @OneToOne(cascade = CascadeType.ALL)
    private Menu menu;
    private Double latitude;
    private Double longitude;
}
