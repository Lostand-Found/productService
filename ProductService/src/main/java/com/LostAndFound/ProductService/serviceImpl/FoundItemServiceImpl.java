package com.LostAndFound.ProductService.serviceImpl;

import com.LostAndFound.ProductService.entities.FoundItem;
import com.LostAndFound.ProductService.exception.ItemNotFoundException;
import com.LostAndFound.ProductService.repository.FoundItemRepository;
import com.LostAndFound.ProductService.services.FoundItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FoundItemServiceImpl implements FoundItemService {

    @Autowired
    private FoundItemRepository foundItemRepository;

    //to save FoundItem data into DB
    @Override
    public FoundItem saveFoundItem(FoundItem foundItem) {
        return foundItemRepository.save(foundItem);
    }

    //to Fetch All FoundItemList from DB
    @Override
    public Iterable<FoundItem> getAllfoundItemList() {
        return foundItemRepository.findAll();
    }

    // Get an FoundItem By ID
    @Override
    public FoundItem foundItemById(int id) {
        Optional<FoundItem> optionalItem = foundItemRepository.findById(id);
        if (optionalItem.isPresent()) {
            return optionalItem.get();
        } else {
            throw new ItemNotFoundException("FoundItem not found with this  ID: " + id);
        }
    }

    //delete FoundItem into DB by ID
    @Override
    public void deleteFoundItem(int id) {
        foundItemRepository.deleteById(id);
    }

    //update FoundItem By ID
    @Override
    public FoundItem updateFoundItem(int id, FoundItem updatedItem) {
        return foundItemRepository.findById(id)
                .map(existingItem -> {
                    // Update only the fields you want to allow modification for
                    existingItem.setItemName(updatedItem.getItemName());
                    existingItem.setDescription(updatedItem.getDescription());
                    existingItem.setPlace(updatedItem.getPlace());
                    existingItem.setItemType(updatedItem.getItemType());
                    existingItem.setDateTime(updatedItem.getDateTime());
                    existingItem.setCity(updatedItem.getCity());
                    existingItem.setPincode(updatedItem.getPincode());
                    existingItem.setState(updatedItem.getState());
                    existingItem.setStatus(updatedItem.getStatus());

                    // Save and return the updated item
                    return foundItemRepository.save(existingItem);
                })
                .orElseThrow(() -> new ItemNotFoundException("FoundItem not found with ID: " + id));
    }
}
