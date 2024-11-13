package com.demirel.ecommerce.repository;

import com.demirel.ecommerce.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
