package com.LostAndFound.ProductService.commonClasses;

import com.LostAndFound.ProductService.Dto.ProductDto;
import java.util.List;
import java.util.UUID;

public class UserProducerMessage {
    private Long userId;
    private List<ProductDto> products;

    public UserProducerMessage() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
