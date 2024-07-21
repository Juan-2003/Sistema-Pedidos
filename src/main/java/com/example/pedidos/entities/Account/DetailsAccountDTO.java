package com.example.pedidos.entities.Account;

import com.example.pedidos.Data.DetailsDataDTO;

public record DetailsAccountDTO(
        Long id,
        DetailsDataDTO data,
        String mail,
        String password,
        String role
) {
    DetailsAccountDTO(Account account){
        this(
                account.getId(),
                new DetailsDataDTO(account.getData()),
                account.getMail(),
                account.getPassword(),
                account.getAccountRole().toString());
    }
}
