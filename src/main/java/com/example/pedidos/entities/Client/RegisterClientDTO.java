package com.example.pedidos.entities.Client;

import com.example.pedidos.entities.Account.RegisterAccountDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record RegisterClientDTO(
        @NotNull
        @JsonProperty("account") RegisterAccountDTO registerAccountDTO
) {
}
