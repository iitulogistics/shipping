package com.shipping.shipping.controllers;

import com.shipping.shipping.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("order")
public class OrdersController {
    private OrderService orderService;

    @Autowired(required = false)
    @Qualifier("defaultOrderService")
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("getOrderById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PostMapping("addOrder")
    public ResponseEntity<?> addOrder(@RequestParam Long orderNumber,
                                      @RequestParam String address,
                                      @RequestParam Long client_id,
                                      @RequestParam Long status_id) {
        return ResponseEntity.ok(orderService.addOrder(orderNumber, address, client_id, status_id));
    }

    @PatchMapping("updateOrder")
    public ResponseEntity<?> updateOrder(@RequestParam Long id,
                                         @RequestParam Long orderNumber,
                                         @RequestParam String address,
                                         @RequestParam Long client_id,
                                         @RequestParam Long status_id) {
        return ResponseEntity.ok(orderService.updateOrderById(id, orderNumber, address, client_id, status_id));
    }

    @PatchMapping("updateOrderStatus")
    public ResponseEntity<?> updateOrderStatus(@RequestParam Long id,
                                               @RequestParam Long status_id) {
        return ResponseEntity.ok(orderService.updateOrderStatus(id, status_id));
    }

    @DeleteMapping("deleteOrderById")
    public ResponseEntity<?> deleteOrderById(@RequestParam Long id) {
        return ResponseEntity.ok(orderService.deleteOrderById(id));
    }
}
