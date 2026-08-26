package com.utec.fullstack.backend.controller;

import com.utec.fullstack.backend.controller.request.CreateProductRequest;
import com.utec.fullstack.backend.controller.request.Product;
import com.utec.fullstack.backend.controller.request.UpdateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapping {

    Product convert(CreateProductRequest createProductRequest);

    Product convert(UpdateProductRequest createProductRequest);

    Product copyFrom(@MappingTarget Product oldProduct, Product oldProductWithNewInfo);
}


