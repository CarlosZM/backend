package com.utec.fullstack.backend.controller;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pe.utec.fullstack.superior.controller.request.CreateProductRequest;
import pe.utec.fullstack.superior.controller.request.Product;
import pe.utec.fullstack.superior.controller.request.UpdateProductRequest;

@Mapper(componentModel = "spring")
public interface ProductMapping {

    Product convert(CreateProductRequest createProductRequest);

    Product convert(UpdateProductRequest createProductRequest);

    Product copyFrom(@MappingTarget Product oldProduct, Product oldProductWithNewInfo);
}


