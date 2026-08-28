package com.utec.fullstack.backend.controller.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdminAnimalRequest {


    @NotNull
    @Size(min = 3, max = 30)
    private String user;

    @NotNull
    @Size(min = 3, max = 30)
    private String name;
}
