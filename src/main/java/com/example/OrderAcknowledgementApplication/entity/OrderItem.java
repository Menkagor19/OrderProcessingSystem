package com.example.OrderAcknowledgementApplication.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Setter
@Getter
@Entity
public class OrderItem implements Serializable {
    @Id
    private Integer productId;
    private String productName;
    private float unitPrice;
    private Integer quantity;
    private float subTotal;
}
