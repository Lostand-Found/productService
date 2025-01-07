package com.LostAndFound.ProductService.exception;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message) {
        super(message);
    }
    public ItemNotFoundException() {
        super("User not found");
    }
}
