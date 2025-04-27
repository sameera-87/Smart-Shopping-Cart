package com.Sameera.smart_shopping.service.cart;

import com.Sameera.smart_shopping.model.Cart;
import com.Sameera.smart_shopping.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}
