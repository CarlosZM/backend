package com.utec.fullstack.backend.business;

import com.utec.fullstack.backend.controller.BalanceMapping;
import com.utec.fullstack.backend.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private BalanceMapping mapper;

    public List<Balance> findAll() {
        return this.mapper.convert(this.balanceRepository.findAll());
    }
}
