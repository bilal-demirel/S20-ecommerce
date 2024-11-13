package com.demirel.ecommerce.service;

import com.demirel.ecommerce.dto.ProductDTO;
import com.demirel.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product addProduct(ProductDTO productDto);
    Product deleteProductById(Long id);
    Product updateProduct(Product product);
}
