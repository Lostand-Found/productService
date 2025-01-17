package com.LostAndFound.ProductService.config;

import com.LostAndFound.ProductService.commonClasses.UserProducerMessage;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserProducerMessage> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserProducerMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<? super String, ? super UserProducerMessage> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put("bootstrap.servers", "localhost:9092");
        config.put("group.id", "product-service-group");
        config.put("key.deserializer", StringDeserializer.class);
        config.put("value.deserializer", JsonDeserializer.class);
        config.put("spring.json.trusted.packages", "*");
        config.put("enable.auto.commit", false);
        config.put("auto.offset.reset", "earliest");

        return new DefaultKafkaConsumerFactory<>(
                config,
                new StringDeserializer(),
                new JsonDeserializer<>(UserProducerMessage.class, false)
        );
    }
}
