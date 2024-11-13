package com.demirel.ecommerce.controller;

import com.demirel.ecommerce.entity.Order;
import com.demirel.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.addOrder(order));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Order> deleteOrderById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.deleteOrderById(id));
    }
}
