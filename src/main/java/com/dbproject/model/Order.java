package com.dbproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Getter
@Setter
@ToString
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private Date date;
    private Long value;
    private User buyer;
    private User seller;
    private Vehicle vehicle;
    private PaymentType paymentType;
    private Collection<Invoice> invoices;


    public Order(Date date, Long value, User buyer_id, User seller_id, Vehicle vehicle, PaymentType paymentType,Collection<Invoice> invoices) {
        this.date = date;
        this.value = value;
        this.buyer = buyer_id;
        this.seller = seller_id;
        this.paymentType = paymentType;
        this.vehicle = vehicle;
        this.invoices = invoices;
    }


}

