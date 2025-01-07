package com.LostAndFound.ProductService.controller;

import com.LostAndFound.ProductService.entity.FoundItem;
import com.LostAndFound.ProductService.service.FoundItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/FoundItem")
public class FoundItemController {
    @Autowired
    private FoundItemService foundItemService;

    @PostMapping
    public ResponseEntity<FoundItem> reportFoundItem(@RequestBody FoundItem foundItem) {
        return ResponseEntity.ok(foundItemService.reportFoundItem(foundItem));
    }

    @GetMapping
    public ResponseEntity<Iterable<FoundItem>> getAllFoundItemsList() {
        return ResponseEntity.ok(foundItemService.getAllFoundItemList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoundItem> foundItemById(@PathVariable int id) {
        return ResponseEntity.ok(foundItemService.foundItemById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoundItem(@PathVariable int id) {
        foundItemService.deleteFoundItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoundItem> updateOrderItem(@PathVariable int id, @RequestBody FoundItem foundItem) {
        FoundItem updatedFoundItem = foundItemService.updateFoundItem(id, foundItem);
        return ResponseEntity.ok(updatedFoundItem);
    }
}
