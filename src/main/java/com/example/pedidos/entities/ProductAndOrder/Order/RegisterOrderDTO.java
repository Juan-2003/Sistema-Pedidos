package com.example.pedidos.entities.ProductAndOrder.Order;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RegisterOrderDTO(
        @NotNull
        Long idClient,
        @NotNull
        List<Long> productsId
) {
}
