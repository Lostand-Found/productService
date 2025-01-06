package com.LostAndFound.ProductService.services;

import com.LostAndFound.ProductService.entities.FoundItem;
import com.LostAndFound.ProductService.entities.LostItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface FoundItemService {

    //to save FoundItem data into DB
    FoundItem saveFoundItem(FoundItem foundItem);

    //to Fetch All FoundItemList from DB
    Iterable<FoundItem> getAllfoundItemList();

    // Get an FoundItem By ID
    FoundItem foundItemById(int id);

    //delete FoundItem into DB by ID
    void deleteFoundItem(int id);

    //update FoundItem By ID
    FoundItem updateFoundItem(int id, FoundItem updatedItem);
}
