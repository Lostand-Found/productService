package com.LostAndFound.ProductService.repository;

import com.LostAndFound.ProductService.entity.FoundItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoundItemRepository extends JpaRepository<FoundItem,Integer> {
}
