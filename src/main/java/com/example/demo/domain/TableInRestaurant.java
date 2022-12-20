package com.example.demo.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Long.class)
public class TableInRestaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference(value = "seat_number-restaurant")
    private Restaurant restaurant;
    @OneToMany(mappedBy = "seatNumber")
    @ToString.Exclude
    private List<Order> orders;
    private Integer numberOfSeats;
    private boolean isBooked;
    private Date startOfBookingTime;
}
