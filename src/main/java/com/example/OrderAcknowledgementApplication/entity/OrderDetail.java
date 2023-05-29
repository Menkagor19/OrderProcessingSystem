package com.example.OrderAcknowledgementApplication.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "orderdetail")
public class OrderDetail implements Serializable {
    @Id
    private Integer orderId;
    private String customerName;
    private String email;
    private String shippingAddress;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private OrderItem orderItems;
    private float totalAmount;
    private Date orderDate;
    private Status status;
}
