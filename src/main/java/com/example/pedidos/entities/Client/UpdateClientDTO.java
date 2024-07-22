package com.example.pedidos.entities.Client;

import com.example.pedidos.entities.Account.UpdateAccountDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record UpdateClientDTO(
        @NotNull
        @JsonProperty("clientId") Long id,
        @NotNull
        @JsonProperty("account") UpdateAccountDTO updateAccountDTO

) {
}
