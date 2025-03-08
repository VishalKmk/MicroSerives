package com.ecommerce.orders.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String productName;
    private double price;
}
