package com.example.pedidos.entities.ProductAndOrder.Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record UpdateOrderDTO(
        @NotNull
        @JsonProperty("orderId") Long id,
        @NotNull
        OrderStatus orderStatus
) {
}
