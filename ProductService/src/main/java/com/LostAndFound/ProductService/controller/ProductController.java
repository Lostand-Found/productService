package com.LostAndFound.ProductService.controller;
import com.LostAndFound.ProductService.entity.Product;
import com.LostAndFound.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/searchItems")
    public ResponseEntity<List<Product>> searchItems(@RequestParam(required = false) String category,
                                                     @RequestParam(required = false) String location,
                                                     @RequestParam(required = false) String keyword) {
        List<Product> list = productService.searchItems(category,location,keyword);
        return ResponseEntity.ok(list);
    }
}
