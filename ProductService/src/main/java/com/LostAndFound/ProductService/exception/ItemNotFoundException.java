package com.LostAndFound.ProductService.exception;

public class ItemNotFoundException extends RuntimeException{

    // Constructor with a custom message
    public ItemNotFoundException(String message) {
        super(message);
    }
    // Default constructor
    public ItemNotFoundException() {
        super("User not found");
    }
}
