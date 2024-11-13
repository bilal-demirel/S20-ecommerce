package com.demirel.ecommerce.controller;

import com.demirel.ecommerce.entity.ProductComment;
import com.demirel.ecommerce.service.ProductCommentService;
import com.demirel.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-comment")
public class ProductCommentController {
    ProductCommentService productCommentService;

    @Autowired
    public ProductCommentController(ProductCommentService productCommentService){
        this.productCommentService = productCommentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductComment>> getAllProductComment(){
        return ResponseEntity.ok(productCommentService.getAllProductComments());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductComment> getProductCommentById(@PathVariable Long id){
        return ResponseEntity.ok(productCommentService.getProductCommentById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<ProductComment> addProductComment(@RequestBody ProductComment productComment){
        return ResponseEntity.ok(productCommentService.addProductComment(productComment));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductComment> deleteProductComment(@PathVariable Long id){
        return ResponseEntity.ok(productCommentService.deleteProductCommentById(id));
    }

}
