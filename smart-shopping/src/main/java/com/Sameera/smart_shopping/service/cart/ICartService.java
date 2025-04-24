package com.Sameera.smart_shopping.service.cart;

import com.Sameera.smart_shopping.model.Cart;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

    Long initializeNewCart();

    Cart getCartById(Long userId);

    Cart getCartByUserId(Long userId);
}
