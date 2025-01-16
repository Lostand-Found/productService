package com.LostAndFound.ProductService.Dto;

import com.LostAndFound.ProductService.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class ProductDto {
    @NotBlank(message = "Product Name is mandatory")
    private String name;
    private String description;
    private String category;
    private StatusEnum status;
    private UUID ownerId;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
