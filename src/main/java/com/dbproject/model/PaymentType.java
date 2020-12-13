package com.dbproject.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Collection;

@Getter
@Setter
@ToString
public class PaymentType {
    @Id
    private Integer id;
    private String type;
    public PaymentType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
}
