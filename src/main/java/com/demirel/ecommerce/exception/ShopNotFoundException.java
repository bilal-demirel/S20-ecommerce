package com.demirel.ecommerce.exception;

public class ShopNotFoundException extends RuntimeException{
    public ShopNotFoundException(String message){
        super(message);
    }
}
