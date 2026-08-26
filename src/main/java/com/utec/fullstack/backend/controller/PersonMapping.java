package com.utec.fullstack.backend.controller;

import com.utec.fullstack.backend.controller.request.CreatePersonRequest;
import com.utec.fullstack.backend.controller.request.Person;
import com.utec.fullstack.backend.controller.request.UpdatePersonRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonMapping {

    Person convert(CreatePersonRequest request);

    Person convert(UpdatePersonRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dni", ignore = true)
    @Mapping(target = "birthDay", ignore = true)
    Person copyFrom(@MappingTarget Person oldProduct, Person oldProductWithNewInfo);
}
