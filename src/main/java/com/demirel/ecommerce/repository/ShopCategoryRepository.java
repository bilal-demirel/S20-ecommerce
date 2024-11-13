package com.demirel.ecommerce.repository;

import com.demirel.ecommerce.entity.ShopCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopCategoryRepository extends JpaRepository<ShopCategory, Long> {
}
