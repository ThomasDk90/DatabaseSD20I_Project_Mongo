package com.dbproject.entities;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@Document(collection = "user")
public class Users {

    @Id
    private String id;
    private Integer ID;
    private String userName;
    private Integer rating;
    private String password;
    private String email;
    private Location location; //many user can have one location
    private Role role; //many user can have one location
    private String[] orders;

    public Users(String userName, String password, Location location, Role role, String email, String[] orders) {
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.role = role;
        this.email = email;
        this.orders = orders;
    }

}