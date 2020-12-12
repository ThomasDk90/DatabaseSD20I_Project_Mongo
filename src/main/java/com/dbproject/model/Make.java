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
    private String code;
    private String name;



    public Make(String name, String code) {
        this.name = name;
        this.code = code;
    }


}
