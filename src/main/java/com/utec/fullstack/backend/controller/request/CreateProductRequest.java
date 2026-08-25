package com.utec.fullstack.backend.controller.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

    @NotEmpty
    @Min(value = 3)
    @Max(value = 30)
    private String name;

    @NotEmpty
    @Max(value = 256)
    @Min(value = 30)
    private String imageUrl;

    @NotNull
    private Currency currency;

    @DecimalMin(value = "0.0")
    private Double purchasePrice;

    @DecimalMin(value = "0.0")
    @DecimalMin(value = "999999.99")
    private Double sellPrice;

    @DecimalMin(value = "0.0")
    @DecimalMin(value = "999.99")
    private Double stock;

    @NotNull
    private Boolean expires;
}
