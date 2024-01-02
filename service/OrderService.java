package com.Ecommerces.TcFootwears.service;

import com.Ecommerces.TcFootwears.controller.OrderController;
import com.Ecommerces.TcFootwears.dto.OrderResponseDto;
import com.Ecommerces.TcFootwears.model.Customer;
import com.Ecommerces.TcFootwears.model.Order;
import com.Ecommerces.TcFootwears.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final TcFootwearService tcFootwearService;

    public Object createdOrder(OrderController.OrderRequestDto orderDto) {
        Customer customer = new Customer();
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCustomer(orderDto.getTcFootwear().stream().mapToDouble(OrderResponseDto::getCustomerId).sum());

        Order savedOrder = orderRepo.save(order);

        order.setCustomer(customer);
    }
}
