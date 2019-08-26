package com.shipping.shipping.services.impl;

import com.shipping.shipping.entities.OrdersEntity;
import com.shipping.shipping.repositories.OrderRepository;
import com.shipping.shipping.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DefaultOrdersService implements OrderService {

    private final OrderRepository orderRepository;

    public DefaultOrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrdersEntity getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrdersEntity> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrdersEntity> getOrdersByIdDriver(Long id) {
        return orderRepository.getOrdersByDriverId(id);
    }

    @Override
    public List<OrdersEntity> getOrdersByIdDriverAndIdStatus(Long id_driver, Long id_status) {
        return orderRepository.getOrdersByDriverAndStatus(id_driver, id_status);
    }

    @Override
    public String addOrder(Long orderNumber,
                           String address,
                           Long client_id,
                           Long status_id,
                           Long product_id,
                           Integer product_amount,
                           Long id_driver) {
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setOrderNumber(orderNumber);
        ordersEntity.setAddress(address);
        ordersEntity.setClient_id(client_id);
        ordersEntity.setCreated(new Date());
        ordersEntity.setStatus_id(status_id);
        ordersEntity.setProduct_id(product_id);
        ordersEntity.setProduct_amount(product_amount);
        ordersEntity.setId_driver(id_driver);

        orderRepository.save(ordersEntity);
        return "Order is added";
    }

    @Override
    public String updateOrderById(Long id,
                                  Long orderNumber,
                                  String address,
                                  Long client_id,
                                  Long status_id,
                                  Long product_id,
                                  Integer product_amount,
                                  Long id_driver) {
        OrdersEntity ordersEntity = orderRepository.getOne(id);
        ordersEntity.setAddress(address);
        ordersEntity.setClient_id(client_id);
        ordersEntity.setStatus_id(status_id);
        ordersEntity.setOrderNumber(orderNumber);
        ordersEntity.setProduct_id(product_id);
        ordersEntity.setProduct_amount(product_amount);
        ordersEntity.setId_driver(id_driver);

        orderRepository.save(ordersEntity);
        return "Order is updated";
    }

    @Override
    public String updateOrderStatus(Long id, Long status_id) {
        OrdersEntity ordersEntity = orderRepository.getOne(id);
        ordersEntity.setStatus_id(status_id);

        orderRepository.save(ordersEntity);
        return "order status id updated";
    }

    @Override
    public String deleteOrderById(Long id) {
        orderRepository.deleteById(id);
        return "Order is deleted";
    }
}
