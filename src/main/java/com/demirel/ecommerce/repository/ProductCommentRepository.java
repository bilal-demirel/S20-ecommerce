package com.demirel.ecommerce.repository;

import com.demirel.ecommerce.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {
}
