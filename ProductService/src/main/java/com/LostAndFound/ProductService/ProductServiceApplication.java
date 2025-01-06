package com.LostAndFound.ProductService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ProductServiceApplication {

	// Create a logger for this class
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceApplication.class);

	public static void main(String[] args) {
		// Log a message when the application starts
		logger.info("Starting ProductServiceApplication...");

		// Run the Spring Boot application
		SpringApplication.run(ProductServiceApplication.class, args);

		// Log after the application has started
		logger.info("ProductServiceApplication started successfully!");
	}
}
