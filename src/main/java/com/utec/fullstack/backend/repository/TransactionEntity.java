package com.utec.fullstack.backend.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String orientation;

    private Double amount;

    private String reason;

    private String type;

    private Integer number;

    private String purchaseNumber;

    @Column(name = "seller_id")
    private String sellerId;

    @Column(name = "can_be_reverted")
    private Boolean canBeReverted;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Transient
    public static final List<String> searchableFields = List.of("purchaseNumber", "canBeReverted", "sellerId");
}
