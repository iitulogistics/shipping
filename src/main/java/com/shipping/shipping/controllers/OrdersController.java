package com.shipping.shipping.controllers;

import com.shipping.shipping.services.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("order")
@Api(tags = "Список заказа", description = "Api для списка заказов")
public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation("Список заказов")
    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @ApiOperation("Вернуть заказ по id")
    @GetMapping("getOrderById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @ApiOperation("Добавить заказ")
    @PostMapping("addOrder")
    public ResponseEntity<?> addOrder(@RequestParam Long orderNumber,
                                      @RequestParam String address,
                                      @RequestParam Long client_id,
                                      @RequestParam Long status_id,
                                      @RequestParam Long product_id,
                                      @RequestParam Integer product_amount) {
        return ResponseEntity.ok(orderService.addOrder(orderNumber, address, client_id, status_id, product_id, product_amount));
    }

    @ApiOperation("Обновить заказ")
    @PatchMapping("updateOrder")
    public ResponseEntity<?> updateOrder(@RequestParam Long id,
                                         @RequestParam Long orderNumber,
                                         @RequestParam String address,
                                         @RequestParam Long client_id,
                                         @RequestParam Long status_id,
                                         @RequestParam Long product_id,
                                         @RequestParam Integer product_amount) {
        return ResponseEntity.ok(orderService.updateOrderById(id, orderNumber, address, client_id, status_id, product_id, product_amount));
    }

    @ApiOperation("Обновить статус заказа")
    @PatchMapping("updateOrderStatus")
    public ResponseEntity<?> updateOrderStatus(@RequestParam Long id,
                                               @RequestParam Long status_id) {
        return ResponseEntity.ok(orderService.updateOrderStatus(id, status_id));
    }

    @ApiOperation("Удалить заказ")
    @DeleteMapping("deleteOrderById")
    public ResponseEntity<?> deleteOrderById(@RequestParam Long id) {
        return ResponseEntity.ok(orderService.deleteOrderById(id));
    }
}
