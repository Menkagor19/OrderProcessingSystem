package com.example.OrderAcknowledgementApplication.repository;

import com.example.OrderAcknowledgementApplication.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
