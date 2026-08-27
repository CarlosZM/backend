package com.utec.fullstack.backend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Integer id;

    private String name;

    private LocalDate start;

    private LocalDate end;
}
