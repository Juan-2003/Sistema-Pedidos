package com.example.pedidos.entities.Account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AccountDTO(
        @Email
        String mail,
        @NotBlank
        String password,
        @NotBlank
        String role
) {
}
