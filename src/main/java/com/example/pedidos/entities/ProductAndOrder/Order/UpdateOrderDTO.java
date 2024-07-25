package com.example.pedidos.entities.ProductAndOrder.Order;

import com.example.pedidos.model.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;

public record UpdateOrderDTO(
        @NotNull
        @JsonProperty("orderId") Long id,
        @NotNull
        OrderStatus orderStatus
) {
}
