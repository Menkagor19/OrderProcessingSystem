package com.example.OrderAcknowledgementApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.naming.NamingException;

@SpringBootApplication
public class OrderProcessingSystemApplication {

	public static void main(String[] args) throws NamingException {
		SpringApplication.run(OrderProcessingSystemApplication.class, args);
	}

}
