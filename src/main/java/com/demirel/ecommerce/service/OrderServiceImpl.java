package com.demirel.ecommerce.service;

import com.demirel.ecommerce.entity.Order;
import com.demirel.ecommerce.exception.OrderNotFoundException;
import com.demirel.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()){
            return optionalOrder.get();
        } else {
            throw new OrderNotFoundException("Order ID that you entered does not exist!");
        }
    }

    @Override
    public Order addOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order deleteOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()){
            orderRepository.deleteById(id);
            return optionalOrder.get();
        }  else {
            throw new OrderNotFoundException("Order ID that you entered does not exist!");
        }
    }

    @Override
    public Order updateOrder(Order order) {
        return null;
    }
}
