package com.example.pedidos.entities.Account;

import com.example.pedidos.Data.UpdateDataDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateAccountDTO(
    @NotNull
    @JsonProperty("data") UpdateDataDTO updateDataDTO,
    @NotBlank
    String password
) {
}
