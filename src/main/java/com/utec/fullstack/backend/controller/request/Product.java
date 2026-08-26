package com.utec.fullstack.backend.controller.request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;

    private String name;

    private String imageUrl;

    private Currency currency;

    private Double purchasePrice;

    private Double sellPrice;

    private Double stock;

    private Boolean expires;

    private Boolean enabled;

    private Boolean flag;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    /*
    public Product(Integer id, String name, String imageUrl, Currency currency, Double purchasePrice, Double sellPrice, Double stock, Boolean expires, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.currency = currency;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
        this.stock = stock;
        this.expires = expires;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public Boolean getExpires() {
        return expires;
    }

    public void setExpires(Boolean expires) {
        this.expires = expires;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    */
}



