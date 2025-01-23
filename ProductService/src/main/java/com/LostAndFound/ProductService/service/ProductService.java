package com.LostAndFound.ProductService.service;

import com.LostAndFound.ProductService.Dto.ProductDto;
import com.LostAndFound.ProductService.response.ApiResponse;

import java.util.UUID;

public interface ProductService
{
    public ApiResponse addItem(ProductDto productDto, Long userId);

}
