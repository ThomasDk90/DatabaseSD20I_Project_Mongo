package com.dbproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Document(collection = "roles")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    private String name;
    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
