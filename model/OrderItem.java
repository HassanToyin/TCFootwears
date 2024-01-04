package com.Ecommerces.TcFootwears.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @Getter @Setter @ToString
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer quantity;

    private Double subtotal;

    public static class setTcFootwear {
    }
}
