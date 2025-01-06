package com.LostAndFound.ProductService.repository;

import com.LostAndFound.ProductService.entities.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostItemRepository extends JpaRepository<LostItem,Integer> {
}
