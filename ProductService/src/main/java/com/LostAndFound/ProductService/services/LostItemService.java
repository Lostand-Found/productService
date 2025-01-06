package com.LostAndFound.ProductService.services;

import com.LostAndFound.ProductService.entities.LostItem;

public interface LostItemService {

    //to save LostItem data into DB
    LostItem saveLostItem(LostItem lostItem);

    //to Fetch All LostItemList from DB
    Iterable<LostItem> getAllLostItemList();

    // Get an LostItem By ID
    LostItem findlostItemById(int id);

    //delete FoundItem into DB by ID
    void deleteLostItem(int id);

    //update FoundItem By ID
    LostItem updateLostItem(int id, LostItem lostItem);
}
