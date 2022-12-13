package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TableInRestaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Restaurant restaurantId;
    private Integer numberOfSeats;
    private boolean isBooked;
    private Date startOfBookingTime;
}
