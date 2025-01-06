package com.LostAndFound.ProductService.controller;

import com.LostAndFound.ProductService.entities.FoundItem;
import com.LostAndFound.ProductService.entities.LostItem;
import com.LostAndFound.ProductService.services.FoundItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/FoundItem")
public class FoundItemController {

    @Autowired
    private FoundItemService foundItemService;

    //to save FoundItem data into DB
    @PostMapping
    public ResponseEntity<FoundItem> saveLostItem(@RequestBody FoundItem foundItem)
    {
        return ResponseEntity.ok(foundItemService.saveFoundItem(foundItem));
    }

    //to Fetch All FoundItemList from DB
    @GetMapping
    public ResponseEntity<Iterable<FoundItem>> getAllLostItemList()
    {
        return ResponseEntity.ok(foundItemService.getAllfoundItemList());
    }

    // Get an FoundItem By ID
    @GetMapping("/{id}")
    public ResponseEntity<FoundItem> foundItemById(@PathVariable int id) {

        return ResponseEntity.ok(foundItemService.foundItemById(id));
    }

    //delete FoundItem into DB by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoundItem(@PathVariable int id) {
        foundItemService.deleteFoundItem(id);
        return ResponseEntity.noContent().build();
    }

    //update FoundItem By ID
    @PutMapping("/{id}")
    public ResponseEntity<FoundItem> updateOrderItem(@PathVariable int id, @RequestBody FoundItem foundItem) {
        FoundItem updatedFoundItem = foundItemService.updateFoundItem(id, foundItem);
        return ResponseEntity.ok(updatedFoundItem);
    }
}
