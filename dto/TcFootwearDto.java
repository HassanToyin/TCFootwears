package com.Ecommerces.TcFootwears.dto;

import lombok.Data;

@Data
public class TcFootwearDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;

}
