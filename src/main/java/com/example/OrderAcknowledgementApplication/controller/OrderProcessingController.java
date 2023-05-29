package com.example.OrderAcknowledgementApplication.controller;

import com.example.OrderAcknowledgementApplication.dto.OrderDetailDTO;
import com.example.OrderAcknowledgementApplication.service.OrderProcessingService;
import com.example.OrderAcknowledgementApplication.utility.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NamingException;
import javax.validation.Valid;

@RestController
@Validated
public class OrderProcessingController {

    @Autowired
    OrderProcessingService orderProcessingService;

    @PostMapping("/orders")
    public ResponseEntity<Object> placeOrder(@Valid @RequestBody OrderDetailDTO orderDetailDTO) throws NamingException {
        int orderId = orderProcessingService.placeOrder(orderDetailDTO);
        String successMessage = "Order placed successfully with orderId " + orderId;
        return ResponseHandler.generateResponse(successMessage, HttpStatus.CREATED);
    }
}
