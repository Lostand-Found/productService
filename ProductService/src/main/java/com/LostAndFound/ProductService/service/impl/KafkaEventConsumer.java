package com.LostAndFound.ProductService.service.impl;

import com.LostAndFound.ProductService.Dto.ProductDto;
import com.LostAndFound.ProductService.commonClasses.UserProducerMessage;
import com.LostAndFound.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class KafkaEventConsumer {
    @Autowired
    private ProductService productService;

    @KafkaListener(topics = "user-product-topic", groupId = "product-service-group")
    public void consumeUserProductMessage(UserProducerMessage userProducerMessage) {
        Long userId = userProducerMessage.getUserId();
        List<ProductDto> products = userProducerMessage.getProducts();
        System.out.println("Consumed message for user ID: " + userId);
        for(ProductDto productDto:products)
        {
           productService.addItem(productDto,userId);
        }

    }

}
