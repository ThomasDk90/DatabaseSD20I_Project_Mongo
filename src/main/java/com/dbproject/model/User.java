package com.dbproject.model;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String user_name;
    private Integer rating;
    private String password;
    private String email;
    private Location location; //many user can have one location
    private Role role; //many user can have one location
    private Collection<Order> orders;


    public User(String id, String user_name, Integer rating, String password, Location location, Role role, String email, Collection<Order> orders) {
        this.id = id;
        this.user_name = user_name;
        this.rating = rating;
        this.password = password;
        this.location = location;
        this.role = role;
        this.email = email;
        this.orders = orders;
    }
/*    public void setId(String id) {
        this.id = id;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public Integer getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getRating() {
        return rating;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Location getLocation() {
        return location;
    }

    public Role getRole() {
        return role;
    }

    public Collection<Order> getOrders() {
        return orders;
    }*/
}