package com.Ecommerces.TcFootwears.controller;

import com.Ecommerces.TcFootwears.model.Order;
import com.Ecommerces.TcFootwears.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")

public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        Object createdOrder = orderService.createdOrder(orderRequestDto);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderRequestDto>> getAllOrders() {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<OrderRequestDto>> getOrderById() {
        return ResponseEntity.ok().build();
    }

    public class OrderRequestDto {
        public Arrays getTcFootwear() {
            return getTcFootwear();
        }
    }
}
