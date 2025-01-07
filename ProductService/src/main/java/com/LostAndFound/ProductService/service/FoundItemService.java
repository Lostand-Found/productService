package com.LostAndFound.ProductService.service;

import com.LostAndFound.ProductService.entity.FoundItem;

public interface FoundItemService {
    FoundItem reportFoundItem(FoundItem foundItem);

    Iterable<FoundItem> getAllFoundItemList();

    FoundItem foundItemById(int id);

    void deleteFoundItem(int id);

    FoundItem updateFoundItem(int id, FoundItem updatedItem);
}
