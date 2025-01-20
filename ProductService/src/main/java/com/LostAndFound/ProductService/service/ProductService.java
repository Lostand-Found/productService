package com.LostAndFound.ProductService.service;

import com.LostAndFound.ProductService.Dto.ProductDto;
import com.LostAndFound.ProductService.entity.Product;
import com.LostAndFound.ProductService.response.ApiResponse;

import java.util.List;

public interface ProductService {
    public ApiResponse addItem(ProductDto productDto);

    public List<Product> searchItems(String category, String location, String keyword);
}
