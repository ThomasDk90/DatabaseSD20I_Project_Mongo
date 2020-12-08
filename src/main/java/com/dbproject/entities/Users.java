package com.dbproject.entities;

import javax.persistence.*;
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
@Document(collection = "users")
public class Users {

    @Id
    private Long id;
    private String userName;
    private Integer rating;
    private String password;

    public Users(String userName, String password, Location location, String email) {
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.email = email;
    }

}