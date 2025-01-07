package com.LostAndFound.ProductService.service.impl;

import com.LostAndFound.ProductService.entity.FoundItem;
import com.LostAndFound.ProductService.exception.ItemNotFoundException;
import com.LostAndFound.ProductService.repository.FoundItemRepository;
import com.LostAndFound.ProductService.service.FoundItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoundItemServiceImpl implements FoundItemService {

    @Autowired
    private FoundItemRepository foundItemRepository;

    @Override
    public FoundItem reportFoundItem(FoundItem foundItem) {
        return foundItemRepository.save(foundItem);
    }

    @Override
    public Iterable<FoundItem> getAllFoundItemList() {
        return foundItemRepository.findAll();
    }

    @Override
    public FoundItem foundItemById(int id) {
        Optional<FoundItem> optionalItem = foundItemRepository.findById(id);
        if (optionalItem.isPresent()) {
            return optionalItem.get();
        } else {
            throw new ItemNotFoundException("FoundItem not found with this  ID: " + id);
        }
    }

    @Override
    public void deleteFoundItem(int id) {
        foundItemRepository.deleteById(id);
    }

    @Override
    public FoundItem updateFoundItem(int id, FoundItem updatedItem) {
        return foundItemRepository.findById(id)
                .map(existingItem -> {
                    existingItem.setItemName(updatedItem.getItemName());
                    existingItem.setDescription(updatedItem.getDescription());
                    existingItem.setPlace(updatedItem.getPlace());
                    existingItem.setItemType(updatedItem.getItemType());
                    existingItem.setDateTime(updatedItem.getDateTime());
                    existingItem.setCity(updatedItem.getCity());
                    existingItem.setPincode(updatedItem.getPincode());
                    existingItem.setState(updatedItem.getState());
                    existingItem.setStatus(updatedItem.getStatus());

                    return foundItemRepository.save(existingItem);
                })
                .orElseThrow(() -> new ItemNotFoundException("FoundItem not found with ID: " + id));
    }
}
