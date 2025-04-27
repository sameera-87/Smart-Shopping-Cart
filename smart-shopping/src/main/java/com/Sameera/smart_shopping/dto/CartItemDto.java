package com.Sameera.smart_shopping.dto;

import com.Sameera.smart_shopping.model.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDto {
    private Long itemId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private ProductDto product;
}
