package com.example.OrderAcknowledgementApplication.dto;

import com.example.OrderAcknowledgementApplication.entity.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
public class OrderDetailDTO {
    private Integer orderId;
    @NotNull(message = "Name should not be null")
    @Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "Name should be alphabets only")
    private String customerName;
    @Email(message = "Should be in email format")
    @NotNull(message = "Email should not be null")
    private String email;
    private String shippingAddress;
    @NotNull
    @Valid
    private OrderItemDTO orderItems;
    private float totalAmount;
    private Date orderDate;
    private Status status;
}
