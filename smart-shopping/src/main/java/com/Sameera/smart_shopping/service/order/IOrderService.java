package com.Sameera.smart_shopping.service.order;

import com.Sameera.smart_shopping.dto.OrderDto;
import com.Sameera.smart_shopping.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);

    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
