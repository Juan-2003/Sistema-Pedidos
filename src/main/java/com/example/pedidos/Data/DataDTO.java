package com.example.pedidos.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataDTO(
        @NotBlank
        String name,
        @NotBlank
        String maternalSurName,
        @NotBlank
        String paternalSurName,
        @NotBlank
        String address,
        @NotBlank
        String phoneNumber,
        @NotNull
        LocalDate birthday
) {
}
