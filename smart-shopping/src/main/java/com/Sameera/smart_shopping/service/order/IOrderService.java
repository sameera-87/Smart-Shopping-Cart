package com.Sameera.smart_shopping.service.order;

import com.Sameera.smart_shopping.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    Order getOrder(Long orderId);

    List<Order> getUserOrders(Long userId);
}
