package com.Ecommerces.TcFootwears.controller;

import com.Ecommerces.TcFootwears.dto.OrderRequestDto;
import com.Ecommerces.TcFootwears.dto.OrderResponseDto;
import com.Ecommerces.TcFootwears.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")

public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        OrderResponseDto createdOrder = orderService.createdOrder(orderService);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED).getBody();
    }

    @GetMapping
    public ResponseEntity<List<OrderRequestDto>> getAllOrders() {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<OrderRequestDto>> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }


}