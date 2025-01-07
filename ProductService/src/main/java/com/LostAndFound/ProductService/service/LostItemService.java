package com.LostAndFound.ProductService.service;

import com.LostAndFound.ProductService.entity.LostItem;

public interface LostItemService {

    LostItem reportLostItem(LostItem lostItem);

    Iterable<LostItem> getAllLostItemList();

    LostItem findLostItemById(int id);

    void deleteLostItem(int id);

    LostItem updateLostItem(int id, LostItem lostItem);
}
