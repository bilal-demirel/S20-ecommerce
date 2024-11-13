package com.demirel.ecommerce.repository;

import com.demirel.ecommerce.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
