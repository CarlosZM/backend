package com.utec.fullstack.backend.controller;

import com.utec.fullstack.backend.controller.request.CreateProductRequest;
import com.utec.fullstack.backend.controller.request.Product;
import com.utec.fullstack.backend.controller.request.UpdateProductRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductMapping {

    @Mapping(source = "naming", target = "name")
    Product convert(CreateProductRequest createProductRequest);

    /**
     * public Product convert(CreateProductRequest createProductRequest) {
     * if (createProductRequest == null) {
     * return null;
     * } else {
     * Product.ProductBuilder product = Product.builder();
     * product.name(createProductRequest.getNaming());
     * product.imageUrl(createProductRequest.getImageUrl());
     * product.currency(createProductRequest.getCurrency());
     * product.purchasePrice(createProductRequest.getPurchasePrice());
     * product.sellPrice(createProductRequest.getSellPrice());
     * product.stock(createProductRequest.getStock());
     * product.expires(createProductRequest.getExpires());
     * return product.build();
     * }
     * }
     */

    Product convert(UpdateProductRequest createProductRequest);

    Product copyFrom(@MappingTarget Product oldProduct, Product oldProductWithNewInfo);
}


