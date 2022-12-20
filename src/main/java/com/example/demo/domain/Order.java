package com.example.demo.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordr")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Long.class)
public class Order implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnoreProperties({"wallpaperURL", "staff", "orders", "tables", "menu"})
    @JsonBackReference(value = "restaurant-order")
    private Restaurant restaurant;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id")
    @JsonBackReference(value = "user-order")
    private User user;
    private boolean needDelivery;
    private Date orderedTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "table_in_restaurant_id")
    @JsonBackReference(value = "seat_number-order")
    private TableInRestaurant seatNumber;
    private boolean isDone;
    @ManyToMany(cascade = CascadeType.ALL)
//    @JsonTypeInfo(use = null)
    @ToString.Exclude
    private List<Dish> dishes;
    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Drink> drinks;
}
