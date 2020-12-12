package com.dbproject.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;


@Getter
@Setter
@ToString
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private Integer ID;
    private Date date;
    private Long value;
    private Users buyer_id;
    private Users seller_id;
    private Vehicle vehicle_ID;

    public Order(String id, Integer ID, Date date, Long value, Users buyer_id, Users seller_id, Vehicle vehicle_ID) {
        this.id = id;
        this.ID = ID;
        this.date = date;
        this.value = value;
        this.buyer_id = buyer_id;
        this.seller_id = seller_id;
        this.vehicle_ID = vehicle_ID;
    }


}

