package com.Ecommerces.TcFootwears.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ecommerces.TcFootwears.model.Order;
public interface OrderRepo extends JpaRepository<Order, Long> {
}
