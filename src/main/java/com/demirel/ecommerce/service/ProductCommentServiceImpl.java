package com.demirel.ecommerce.service;

import com.demirel.ecommerce.entity.ProductComment;
import com.demirel.ecommerce.exception.ProductCommentNotFoundException;
import com.demirel.ecommerce.repository.ProductCommentRepository;
import com.demirel.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCommentServiceImpl implements ProductCommentService{
    ProductCommentRepository productCommentRepository;

    @Autowired
    public ProductCommentServiceImpl(ProductCommentRepository productCommentRepository){
        this.productCommentRepository = productCommentRepository;
    }
    @Override
    public List<ProductComment> getAllProductComments() {
        return productCommentRepository.findAll();
    }

    @Override
    public ProductComment getProductCommentById(Long id) {
        Optional<ProductComment> optionalProductComment = productCommentRepository.findById(id);
        if(optionalProductComment.isPresent()){
            return optionalProductComment.get();
        } else {
            throw new ProductCommentNotFoundException("Product Comment ID that you entered does not exist!");
        }
    }

    @Override
    public ProductComment addProductComment(ProductComment productComment) {
        productCommentRepository.save(productComment);
        return productComment;
    }

    @Override
    public ProductComment deleteProductCommentById(Long id) {
        Optional<ProductComment> optionalProductComment = productCommentRepository.findById(id);
        if(optionalProductComment.isPresent()){
            productCommentRepository.deleteById(id);
            return optionalProductComment.get();
        } else {
            throw new ProductCommentNotFoundException("Product Comment ID that you entered does not exist!");
        }
    }

    @Override
    public ProductComment updateProductComment(ProductComment productComment) {
        return null;
    }
}
