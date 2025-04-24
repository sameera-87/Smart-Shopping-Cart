package com.Sameera.smart_shopping.repository;

import com.Sameera.smart_shopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
