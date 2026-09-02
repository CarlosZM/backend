package com.utec.fullstack.backend.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "balance")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer identifier;

    private Double amount;

    private String userId;

    //IS_LOCKED
    //ISLOCKED
    //BLOQUEADO
    private Boolean isLocked;

    private Integer amountTransactions;

    private Integer createdBy;

    private LocalDateTime createdAt;

    private Integer updatedBy;

    private LocalDateTime updatedAt;
}
