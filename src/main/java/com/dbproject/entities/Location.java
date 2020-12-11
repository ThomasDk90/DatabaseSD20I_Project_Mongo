package com.dbproject.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Getter
@Setter
@ToString
@Document(collection = "location")
public class Location {

    @Id
    private String id;
    private Integer ID;
    private String name;
    private Integer postalCode;

    public Location(String id, Integer ID, String name, int postalCode) {
        this.id = id;
        this.ID = ID;
        this.name = name;
        this.postalCode = postalCode;
    }
}

