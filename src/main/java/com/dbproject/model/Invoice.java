package com.dbproject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
public class Invoice {

    @Id
    private Long ID;
    private Date date;
    private Long amount;

    public Invoice(Long ID, Date date, Long amount, String detail) {
        this.ID = ID;
        this.date = date;
        this.amount = amount;
    }
}
