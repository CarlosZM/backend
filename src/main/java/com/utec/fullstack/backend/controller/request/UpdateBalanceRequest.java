package com.utec.fullstack.backend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBalanceRequest {

    private Double amount;

    private Integer amountTransactions;
}