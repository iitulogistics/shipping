package com.shipping.shipping.repositories;

import com.shipping.shipping.entities.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrdersEntity, Long> {
}
