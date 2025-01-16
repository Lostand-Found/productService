package com.LostAndFound.ProductService.service.impl;

import com.LostAndFound.ProductService.Dto.ProductDto;
import com.LostAndFound.ProductService.entity.Product;
import com.LostAndFound.ProductService.repository.ProductRepository;
import com.LostAndFound.ProductService.response.ApiResponse;
import com.LostAndFound.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepo;

    @Override
    public ApiResponse addItem(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        product.setStatus(productDto.getStatus());
        product.setOwnerId(productDto.getOwnerId());
        product.setLocation(productDto.getLocation());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        productRepo.save(product);
        return new ApiResponse.Builder()
                .message("Successfully reported")
                .statusCode(HttpStatus.CREATED)
                .success(true).build();
    }
}
