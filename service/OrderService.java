package com.Ecommerces.TcFootwears.service;

import com.Ecommerces.TcFootwears.controller.OrderController;
import com.Ecommerces.TcFootwears.dto.OrderRequestDto;
import com.Ecommerces.TcFootwears.dto.OrderResponseDto;
import com.Ecommerces.TcFootwears.model.Customer;
import com.Ecommerces.TcFootwears.model.Order;
import com.Ecommerces.TcFootwears.model.OrderItem;
import com.Ecommerces.TcFootwears.model.TcFootwear;
import com.Ecommerces.TcFootwears.repository.OrderItemRepo;
import com.Ecommerces.TcFootwears.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final OrderItemService orderItemService;
    private final CustomerService customerService;
    private final TcFootwearService tcFootwearService;
    private final OrderItemRepo orderItemRepo;

    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto){
        Customer customer = customerService.getCustomer(orderRequestDto.getCustomerId());
        final List<OrderItem>[] orderItems = new List[]{new ArrayList<>()};
        orderRequestDto.getTcFootwear().forEach(orderItemDto -> {
            TcFootwear tcFootwear = tcFootwearService.getTcFootwearById(orderItems[0].getTcFootwearId());

            double subTotal = tcFootwear.getPrice() * orderItemDto.getQuantity();
            OrderItem = new OrderItem();

            newOrderItem.setTcFootwear(TcFootwear);
            newOrderItem.setSubtotal(subTotal);
            newOrderItem.setQuantity(orderItemDto.getQuantity());

            OrderItem saved = orderItemRepo.save(newOrderItem);

            orderItems.add(saved);
        });
        double sum = Arrays.stream(orderItems).mapToDouble(OrderItem::getSubtotal).sum();

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(sum);
        order.setCustomer(customer);
        order.getOrderItems().addAll(orderItems);

        Order savedOrder = orderRepo.save(order);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setCustomerId(customer.getId());
        orderResponseDto.getOrderDate(savedOrder.getOrderDate());
        orderResponseDto.setTotalAmount(savedOrder.getTotalAmount());
        orderResponseDto.setOrderItem(orderItems);

        return orderResponseDto;
    }


    public OrderResponseDto createdOrder(OrderService orderService) {
    }
}
