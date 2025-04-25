package com.Sameera.smart_shopping.dto;

import java.math.BigDecimal;
import java.util.Set;

public class CartDto {
    private Long cartId;
    private Set<CartItemDto> items;
    private BigDecimal totalAmount;

}
