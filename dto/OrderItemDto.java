package com.Ecommerces.TcFootwears.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    @NonNull private Long tcFootwearId;
    @NonNull private Integer quantity;
    private Double subtotal;

}
