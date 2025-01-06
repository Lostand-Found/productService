package com.LostAndFound.ProductService.controller;

import com.LostAndFound.ProductService.request.ProductReq;
import com.LostAndFound.ProductService.request.ProductRequest2;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

    @RequestMapping(path = "product", method = RequestMethod.GET)
    public String getProduct(@RequestBody ProductRequest2 productRequest2){
        return null;
    }

    @GetMapping("/maasdaa")
    public String getPro(@RequestBody ProductReq productReq){
        return  null;
    }

}
