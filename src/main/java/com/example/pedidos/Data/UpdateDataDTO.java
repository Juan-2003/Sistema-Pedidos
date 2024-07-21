package com.example.pedidos.Data;

import jakarta.validation.constraints.NotBlank;

public record UpdateDataDTO(
        @NotBlank
        String name,
        @NotBlank
        String maternalSurName,
        @NotBlank
        String paternalSurName,
        @NotBlank
        String address,
        @NotBlank
        String phoneNumber
) {
}
