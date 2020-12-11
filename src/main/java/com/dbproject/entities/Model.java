package com.dbproject.entities;

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
    private Integer ID;
    private String name;
    private String code;
/*    private Integer make_id;*/
    private Make make_id;

    public Model(String id, Integer ID, String name, String code, Make make_id) {
        this.id = id;
        this.ID = ID;
        this.name = name;
        this.code = code;
        this.make_id = make_id;
    }


}
