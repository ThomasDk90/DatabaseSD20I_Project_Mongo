package com.dbproject.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Getter
@Setter
@ToString
public class PaymentType {

    private Integer id;
    private String type;
    public PaymentType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
}
