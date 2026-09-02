package com.utec.fullstack.backend.business;

import com.utec.fullstack.backend.controller.BalanceMapping;
import com.utec.fullstack.backend.repository.BalanceEntity;
import com.utec.fullstack.backend.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Balance getById(Integer id) {
        return this.mapper.convert(this.balanceRepository.getReferenceById(id));
    }

    public Balance create(Balance domain) {
        domain.setCreatedAt(LocalDateTime.now());
        return this.mapper.convert( //MODELO A NEGOCIO
                this.balanceRepository.saveAndFlush(
                        this.mapper.convert(domain) //NEGOCIO A MODELO
                )
        );
    }

    public Balance update(Integer id, Balance domain) {

        BalanceEntity oldBalance = this.balanceRepository.getReferenceById(id);

        BalanceEntity newBalance = this.mapper.copy(oldBalance, domain);

        newBalance.setUpdatedAt(LocalDateTime.now());

        return this.mapper.convert( //MODELO A NEGOCIO
                this.balanceRepository.saveAndFlush(newBalance)
        );
    }
}
