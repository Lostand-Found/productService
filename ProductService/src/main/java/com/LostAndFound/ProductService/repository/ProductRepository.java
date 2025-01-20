package com.LostAndFound.ProductService.repository;

import com.LostAndFound.ProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query(value = "SELECT * FROM product " +
            "WHERE (:category IS NULL OR category = :category) " +
            "AND (:location IS NULL OR location = :location) " +
            "AND (:keyword IS NULL OR LOWER(name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(description) LIKE LOWER(CONCAT('%', :keyword, '%')))",
            nativeQuery = true)
    List<Product> searchItems(String category, String location, String keyword);
}
