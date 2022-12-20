package com.example.demo.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Dish> dishes;
    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Drink> drinks;

}
