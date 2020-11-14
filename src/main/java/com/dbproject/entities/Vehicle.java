package com.dbproject.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long year;
    private String colour;
    private String fuelType;
    private Long kms;
    private Long hp;
    private Float value;
    private Integer available;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Model model;

    //TODO check if this should be a fk, if so can it be null??

    private Long orderID;

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Long getKms() {
        return kms;
    }

    public void setKms(Long kms) {
        this.kms = kms;
    }

    public Long getHp() {
        return hp;
    }

    public void setHp(Long hp) {
        this.hp = hp;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id &&
                year == vehicle.year &&
                fuelType == vehicle.fuelType &&
                kms == vehicle.kms &&
                hp == vehicle.hp &&
                Float.compare(vehicle.value, value) == 0 &&
                available == vehicle.available &&
                orderID == vehicle.orderID &&
                Objects.equals(colour, vehicle.colour) &&
                Objects.equals(location, vehicle.location) &&
                Objects.equals(user, vehicle.user) &&
                Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, colour, fuelType, kms, hp, value, available, location, user, model, orderID);
    }
}
