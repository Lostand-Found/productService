package com.LostAndFound.ProductService.serviceImpl;

import com.LostAndFound.ProductService.entities.LostItem;
import com.LostAndFound.ProductService.exception.ItemNotFoundException;
import com.LostAndFound.ProductService.repository.LostItemRepository;
import com.LostAndFound.ProductService.services.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LostItemServiceImpl implements LostItemService {

    @Autowired
    LostItemRepository lostItemRepository;

    //to save LostItem data into DB
    @Override
    public LostItem saveLostItem(LostItem lostItem) {
        return lostItemRepository.save(lostItem);
    }

    //to Fetch All LostItemList from DB
    @Override
    public Iterable<LostItem> getAllLostItemList() {
        return lostItemRepository.findAll();
    }

    // Get an LostItem By ID
    @Override
    public LostItem findlostItemById(int id) {
        Optional<LostItem> optionalItem = lostItemRepository.findById(id);
        if (optionalItem.isPresent()) {
            return optionalItem.get();
        } else {
            throw new ItemNotFoundException("LostItem not found with this  ID: " + id);
        }
    }

    //delete FoundItem into DB by ID
    @Override
    public void deleteLostItem(int id) {
        lostItemRepository.deleteById(id);
    }

    //update FoundItem By ID
    @Override
    public LostItem updateLostItem(int id, LostItem updatedItem) {
        return lostItemRepository.findById(id)
                .map(existingItem -> {
                    // Update only the fields you want to allow modification for
                    existingItem.setItemName(updatedItem.getItemName());
                    existingItem.setDescription(updatedItem.getDescription());
                    existingItem.setPlace(updatedItem.getPlace());
                    existingItem.setItem_lost(updatedItem.getItem_lost());
                    existingItem.setDateTime(updatedItem.getDateTime());
                    existingItem.setCity(updatedItem.getCity());
                    existingItem.setPincode(updatedItem.getPincode());
                    existingItem.setState(updatedItem.getState());
                    existingItem.setStatus(updatedItem.getStatus());

                    // Save and return the updated item
                    return lostItemRepository.save(existingItem);
                })
                .orElseThrow(() -> new ItemNotFoundException("LostItem not found with ID: " + id));
    }
}
