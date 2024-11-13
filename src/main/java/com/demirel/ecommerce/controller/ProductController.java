package com.demirel.ecommerce.controller;

import com.demirel.ecommerce.dto.ProductDTO;
import com.demirel.ecommerce.entity.Product;
import com.demirel.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.AppReopenedEvent;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDto){
        return ResponseEntity.ok(productService.addProduct(productDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.deleteProductById(id));
    }
}
