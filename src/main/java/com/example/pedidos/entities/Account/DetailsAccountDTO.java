package com.example.pedidos.entities.Account;

import com.example.pedidos.Data.DetailsDataDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"accountId", "data", "mail", "password", "role"})
public record DetailsAccountDTO(
        @JsonProperty("accountId") Long id,
        @JsonProperty("data")DetailsDataDTO detailsDataDTO,
        String mail,
        String password,
        String role
) {
    public DetailsAccountDTO(Account account){
        this(
                account.getId(),
                new DetailsDataDTO(account.getData()),
                account.getMail(),
                account.getPassword(),
                account.getAccountRole().toString());
    }
}
