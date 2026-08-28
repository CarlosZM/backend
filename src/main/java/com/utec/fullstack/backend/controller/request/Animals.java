package com.utec.fullstack.backend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Animals {

    private Integer id;

    private String name;

    private String user;

    private LocalDateTime createdAt;

}



