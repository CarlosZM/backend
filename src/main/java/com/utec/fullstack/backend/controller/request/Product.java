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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}



