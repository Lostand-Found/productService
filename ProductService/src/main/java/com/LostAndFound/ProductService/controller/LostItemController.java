package com.LostAndFound.ProductService.controller;

import com.LostAndFound.ProductService.entity.LostItem;
import com.LostAndFound.ProductService.service.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/LostItem")
public class LostItemController {

    @Autowired
    LostItemService lostItemService;

    @PostMapping
    public ResponseEntity<LostItem> reportLostItem(@RequestBody LostItem lostItem) {
        return ResponseEntity.ok(lostItemService.reportLostItem(lostItem));
    }

    @GetMapping
    public ResponseEntity<Iterable<LostItem>> getAllLostItemsList() {
        return ResponseEntity.ok(lostItemService.getAllLostItemList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LostItem> getlostItemById(@PathVariable int id) {

        return ResponseEntity.ok(lostItemService.findLostItemById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLostItem(@PathVariable int id) {
        lostItemService.deleteLostItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LostItem> updateLostItem(@PathVariable int id, @RequestBody LostItem lostItem) {
        LostItem updatedLostItem = lostItemService.updateLostItem(id, lostItem);
        return ResponseEntity.ok(updatedLostItem);
    }
}
