package com.utec.fullstack.backend.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transaction_revert")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransactionRevertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "transaction_origin")
    private UUID transactionOrigin;

    @Column(name = "transaction_reverted")
    private UUID transactionReverted;

    @Column(name = "seller_id")
    private String sellerId;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
