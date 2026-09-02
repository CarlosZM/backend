package com.utec.fullstack.backend.controller;

import com.utec.fullstack.backend.business.Balance;
import com.utec.fullstack.backend.controller.request.CreatePersonRequest;
import com.utec.fullstack.backend.controller.request.Person;
import com.utec.fullstack.backend.controller.request.UpdatePersonRequest;
import com.utec.fullstack.backend.repository.BalanceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BalanceMapping {

    Balance convert(BalanceEntity entity);

    List<Balance> convert(List<BalanceEntity> entity);


}
