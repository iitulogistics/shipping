package com.shipping.shipping.services;

import com.shipping.shipping.entities.OrdersEntity;

import java.util.Date;
import java.util.List;

public interface OrderService {
    OrdersEntity getOrderById(Long id);

    List<OrdersEntity> getOrders();

    String addOrder(Long orderNumber,
                    String address,
                    Long client_id,
                    Long status_id,
                    Long product_id,
                    Integer product_amount);

    String updateOrderById(Long id,
                           Long orderNumber,
                           String address,
                           Long client_id,
                           Long status_id,
                           Long product_id,
                           Integer product_amount);

    String updateOrderStatus(Long id, Long status_id);

    String deleteOrderById(Long id);
}
