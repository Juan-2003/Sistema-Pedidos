package com.example.pedidos.entities.Account;

import com.example.pedidos.Data.DataDTO;
import com.example.pedidos.Data.DetallesDataDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetallesAccountDTO(
        Long id,
        DetallesDataDTO data,
        String mail,
        String password,
        String role
) {
    DetallesAccountDTO(Account account){
        this(
                account.getId(),
                new DetallesDataDTO(account.getData()),
                account.getMail(),
                account.getPassword(),
                account.getAccountRole().toString());
    }
}
