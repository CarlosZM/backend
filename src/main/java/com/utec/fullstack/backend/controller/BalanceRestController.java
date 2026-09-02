package com.utec.fullstack.backend.controller;

import com.utec.fullstack.backend.business.Balance;
import com.utec.fullstack.backend.business.BalanceService;
import com.utec.fullstack.backend.controller.request.CreateBalanceRequest;
import com.utec.fullstack.backend.controller.request.UpdateBalanceRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balance")
public class BalanceRestController {

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private BalanceMapping mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Balance> getBalances() {
        return this.balanceService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Balance getBalanceById(@PathVariable Integer id) {
        return this.balanceService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Balance createBalance(
            @Valid @RequestBody CreateBalanceRequest req
    ) {
        return this.balanceService.create(
                this.mapper.convert(req)
        );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Balance updateBalance(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateBalanceRequest req
    ) {
        return this.balanceService.update(id,
                this.mapper.convert(req));
    }
}
