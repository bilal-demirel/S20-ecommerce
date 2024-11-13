package com.demirel.ecommerce.exception;

public class ProductCommentNotFoundException extends RuntimeException{
    public ProductCommentNotFoundException(String message){
        super(message);
    }
}
