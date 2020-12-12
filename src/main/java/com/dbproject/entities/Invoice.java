package com.dbproject.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.tuple.GeneratedValueGeneration;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Document(collection = "invoice")
public class Invoice {

    @Id
    private Long ID;
    private Date date;
    private Long amount;
    private Order order;
    private Users user;
    private String detail;

    public Invoice(Long ID, Date date, Long amount, Order order, Users user, String detail) {
        this.ID = ID;
        this.date = date;
        this.amount = amount;
        this.order = order;
        this.user = user;
        this.detail = detail;
    }
}
