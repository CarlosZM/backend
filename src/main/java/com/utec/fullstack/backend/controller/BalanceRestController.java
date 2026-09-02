package com.utec.fullstack.backend.controller;

import com.utec.fullstack.backend.business.Balance;
import com.utec.fullstack.backend.business.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/balance")
public class BalanceRestController {

    @Autowired
    private BalanceService balanceService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Balance> getBalances(){
        return this.balanceService.findAll();
    }
}
