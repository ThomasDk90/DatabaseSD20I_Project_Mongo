package com.dbproject.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@ToString
@Document(collection = "paymentType")
public class PaymentType {
    @Id
    private String id;
    private String type;
    public PaymentType(String id, String type) {
        this.id = id;
        this.type = type;
    }
}
