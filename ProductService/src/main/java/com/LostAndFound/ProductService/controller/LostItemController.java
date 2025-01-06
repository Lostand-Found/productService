package com.LostAndFound.ProductService.controller;

import com.LostAndFound.ProductService.entities.FoundItem;
import com.LostAndFound.ProductService.entities.LostItem;
import com.LostAndFound.ProductService.services.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/LostItem")
public class LostItemController {

    @Autowired
    LostItemService lostItemService;

    //to save LostItem data into DB
    @PostMapping
    public ResponseEntity<LostItem> saveLostItem(@RequestBody LostItem lostItem)
    {
        return ResponseEntity.ok(lostItemService.saveLostItem(lostItem));
    }
    //to Fetch All LostItemList from DB
    @GetMapping
    public ResponseEntity<Iterable<LostItem>> getAllLostItemList()
    {
        return ResponseEntity.ok(lostItemService.getAllLostItemList());
    }

    // Get an LostItem By ID
    @GetMapping("/{id}")
    public ResponseEntity<LostItem> lostItemById(@PathVariable int id) {

        return ResponseEntity.ok(lostItemService.findlostItemById(id));
    }
    //delete FoundItem into DB by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLostItem(@PathVariable int id) {
        lostItemService.deleteLostItem(id);
        return ResponseEntity.noContent().build();
    }

    //update FoundItem By ID
    @PutMapping("/{id}")
    public ResponseEntity<LostItem> updateOrderItem(@PathVariable int id, @RequestBody LostItem lostItem) {
        LostItem updatedLostItem = lostItemService.updateLostItem(id, lostItem);
        return ResponseEntity.ok(updatedLostItem);
    }
}
