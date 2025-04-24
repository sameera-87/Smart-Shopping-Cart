package com.Sameera.smart_shopping.service.order;

import com.Sameera.smart_shopping.model.Order;

public interface IOrderService {
    Order placeOrder(Long userId);
    Order getOrder(Long orderId);
}
