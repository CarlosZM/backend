package com.utec.fullstack.backend.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "balance")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Double amount;

    @Column(name = "seller_id")
    private String sellerId;

    @Column(name = "is_locked")
    private Boolean isLocked;

    private Boolean flag;

    @Column(name = "number")
    private Integer amountTransactions;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
