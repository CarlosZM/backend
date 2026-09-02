package com.utec.fullstack.backend.controller;

import com.utec.fullstack.backend.business.Balance;
import com.utec.fullstack.backend.controller.request.*;
import com.utec.fullstack.backend.repository.BalanceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BalanceMapping {

    Balance convert(BalanceEntity entity);

    List<Balance> convert(List<BalanceEntity> entity);

    Balance convert(CreateBalanceRequest request);

    Balance convert(UpdateBalanceRequest req);

    BalanceEntity convert(Balance domain);

    BalanceEntity copy(@MappingTarget BalanceEntity oldBalance, Balance domain);
}
