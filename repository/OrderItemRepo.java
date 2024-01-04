package com.Ecommerces.TcFootwears.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerces.TcFootwears.model.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
}
