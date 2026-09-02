package com.utec.fullstack.backend.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "balance_plain")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BalancePlain {

    @Id
    @GeneratedValue
    private Integer identifier;

    private Double amount;

    private String userId;

    private Boolean isLocked;

    @Column(name = "is_deleted")
    private Boolean deleted;

    private Integer amountTransactions;

    private Integer createdBy;

    private LocalDateTime createdAt;

    private Integer updatedBy;

    private LocalDateTime updatedAt;
}
