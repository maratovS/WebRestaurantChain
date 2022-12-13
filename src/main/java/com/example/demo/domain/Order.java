package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ordr")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order { //todo: add relations
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id")
    private User user;
    private boolean needDelivery;
    private Date orderedTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tableinrestaurant_id")
    private TableInRestaurant seatNumber;
    private boolean isDone; // refactor with enum {done, processing, delivering, cooking}
    //todo: add dishes and drinks
}
