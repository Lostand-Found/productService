package com.LostAndFound.ProductService.service.impl;

import com.LostAndFound.ProductService.entity.LostItem;
import com.LostAndFound.ProductService.exception.ItemNotFoundException;
import com.LostAndFound.ProductService.repository.LostItemRepository;
import com.LostAndFound.ProductService.service.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LostItemServiceImpl implements LostItemService {

    @Autowired
    LostItemRepository lostItemRepository;

    @Override
    public LostItem reportLostItem(LostItem lostItem) {
        return lostItemRepository.save(lostItem);
    }

    @Override
    public Iterable<LostItem> getAllLostItemList() {
        return lostItemRepository.findAll();
    }

    @Override
    public LostItem findLostItemById(int id) {
        Optional<LostItem> optionalItem = lostItemRepository.findById(id);
        if (optionalItem.isPresent()) {
            return optionalItem.get();
        } else {
            throw new ItemNotFoundException("LostItem not found with this  ID: " + id);
        }
    }

    @Override
    public void deleteLostItem(int id) {
        lostItemRepository.deleteById(id);
    }

    @Override
    public LostItem updateLostItem(int id, LostItem updatedItem) {
        return lostItemRepository.findById(id)
                .map(existingItem -> {

                    existingItem.setItemName(updatedItem.getItemName());
                    existingItem.setDescription(updatedItem.getDescription());
                    existingItem.setPlace(updatedItem.getPlace());
                    existingItem.setItem_lost(updatedItem.getItem_lost());
                    existingItem.setDateTime(updatedItem.getDateTime());
                    existingItem.setCity(updatedItem.getCity());
                    existingItem.setPincode(updatedItem.getPincode());
                    existingItem.setState(updatedItem.getState());
                    existingItem.setStatus(updatedItem.getStatus());


                    return lostItemRepository.save(existingItem);
                })
                .orElseThrow(() -> new ItemNotFoundException("LostItem not found with ID: " + id));
    }
}
