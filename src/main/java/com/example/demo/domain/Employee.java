package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurant placeOfWork;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role speciality;
    private boolean isWorking;

    public Employee() {
    }

    public Employee(String name, String surname, Role speciality, boolean isWorking) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.isWorking = isWorking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Role speciality) {
        this.speciality = speciality;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
