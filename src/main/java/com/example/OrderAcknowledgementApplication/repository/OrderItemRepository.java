package com.example.OrderAcknowledgementApplication.repository;

import com.example.OrderAcknowledgementApplication.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
