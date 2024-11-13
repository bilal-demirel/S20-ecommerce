package com.demirel.ecommerce.service;

import com.demirel.ecommerce.entity.ProductComment;

import java.util.List;

public interface ProductCommentService {
    List<ProductComment> getAllProductComments();
    ProductComment getProductCommentById(Long id);
    ProductComment addProductComment(ProductComment productComment);
    ProductComment deleteProductCommentById(Long id);
    ProductComment updateProductComment(ProductComment productComment);
}
