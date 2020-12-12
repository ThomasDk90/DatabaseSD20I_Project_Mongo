package com.dbproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


@Getter
@Setter
@ToString
@Document(collection = "model")
public class Model {

    @Id
    private String id;
    private String name;
    private String code;
    private Make make_id;

    public Model(Integer ID, String name, String code, Make make_id) {
        this.name = name;
        this.code = code;
        this.make_id = make_id;
    }


}
