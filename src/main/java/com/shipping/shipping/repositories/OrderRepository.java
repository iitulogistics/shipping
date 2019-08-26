package com.shipping.shipping.repositories;

import com.shipping.shipping.entities.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrdersEntity, Long> {

    @Query("select o from OrdersEntity o where o.id_driver = ?1")
    List<OrdersEntity> getOrdersByDriverId(Long id);

    @Query("select o from OrdersEntity o where o.id_driver = ?1 and o.status_id = ?2")
    List<OrdersEntity> getOrdersByDriverAndStatus(Long id_driver, Long id_status);
}
