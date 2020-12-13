package com.dbproject.model;

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
    private String name;
    private Integer postal_code;

    public Location(String name, Integer postal_code) {
        this.name = name;
        this.postal_code = postal_code;
    }
}

