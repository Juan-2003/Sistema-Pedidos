package com.example.pedidos.entities.Account;

import com.example.pedidos.Data.DataDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterAccountDTO(
        @NotNull
        @JsonAlias("data") DataDTO dataDTO,
        @Email
        String mail,
        @NotBlank
        String password,
        @NotBlank
        String role
) {
}
