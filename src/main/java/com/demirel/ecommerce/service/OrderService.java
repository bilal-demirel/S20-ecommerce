package com.demirel.ecommerce.service;


import com.demirel.ecommerce.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order addOrder(Order order);
    Order deleteOrderById(Long id);
    Order updateOrder(Order order);
}
