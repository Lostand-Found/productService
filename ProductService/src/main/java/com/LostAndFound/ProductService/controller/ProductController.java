package com.LostAndFound.ProductService.controller;

import com.LostAndFound.ProductService.Dto.ProductDto;
import com.LostAndFound.ProductService.enums.StatusEnum;
import com.LostAndFound.ProductService.response.ApiResponse;
import com.LostAndFound.ProductService.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/reportLostItem/{userId}")
    public ResponseEntity<ApiResponse> reportLostItem(@Valid @RequestBody ProductDto productDto)
    {
        productDto.setStatus(StatusEnum.LOST);
        ApiResponse response=productService.addItem(productDto);
        return new ResponseEntity<>(response,response.getStatusCode());
    }

    @PostMapping("/reportFoundItem/{userId}")
    public ResponseEntity<ApiResponse> reportFoundItem(@RequestBody ProductDto productDto, @PathVariable("userId") UUID userId)
    {
        productDto.setStatus(StatusEnum.FOUND);
        productDto.setOwnerId(userId);
        ApiResponse response=productService.addItem(productDto);
        return new ResponseEntity<>(response,response.getStatusCode());
    }
}
