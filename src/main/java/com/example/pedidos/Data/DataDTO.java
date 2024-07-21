package com.example.pedidos.Data;

import com.example.pedidos.entities.Account.AccountDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataDTO(
        @NotBlank
        String name,
        @NotBlank
        String maternalSurName,
        @NotBlank
        String paternalSurName,
        @NotBlank
        String address,
        @NotBlank
        String phoneNumber,
        @NotNull
        LocalDate birthday
) {
}
