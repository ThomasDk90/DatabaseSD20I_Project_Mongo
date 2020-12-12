package com.dbproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Document(collection = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Long year;
    private String colour;
    private String fuelType;
    private Long kms;
    private Long hp;
    private Long value;
    private Integer available = 1;
    private Location location;
    private User user;
    private Make make;
    private Model model;

    public Vehicle(String id, Long year, String colour, String fuelType,
                   Long kms, Long hp, Long value, Integer available, Location location,
                   User user, Make make, Model model) {
        this.id = id;
        this.year = year;
        this.colour = colour;
        this.fuelType = fuelType;
        this.kms = kms;
        this.hp = hp;
        this.value = value;
        this.available = available;
        this.location = location;
        this.user = user;
        this.make = make;
        this.model = model;
    }



}
