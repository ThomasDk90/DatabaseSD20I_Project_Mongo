package com.dbproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Getter
@Setter
@ToString
@Document(collection = "make")
public class Make {

    @Id
    private String id;
    private Integer ID;
    private String code;
    private String name;



    public Make(String id, Integer ID, String name, String code) {
        this.id = id;
        this.ID = ID;
        this.name = name;
        this.code = code;
    }


}
