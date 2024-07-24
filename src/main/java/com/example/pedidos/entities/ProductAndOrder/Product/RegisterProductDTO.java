package com.example.pedidos.entities.ProductAndOrder.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterProductDTO(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        Double price
) {
}
