package com.example.OrderAcknowledgementApplication.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemDTO {
    private Integer productId;
    private String productName;
    private float unitPrice;
    private Integer quantity;
    private float subTotal;
}
