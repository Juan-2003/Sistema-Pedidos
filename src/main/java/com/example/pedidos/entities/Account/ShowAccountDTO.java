package com.example.pedidos.entities.Account;

import com.example.pedidos.Data.ShowDataDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"accountId", "data", "mail"})
public record ShowAccountDTO(
    @JsonProperty("accountId")Long id,
    @JsonProperty("data") ShowDataDTO showDataDTO,
    String mail
) {
    public ShowAccountDTO(Account account){
        this(account.getId(), new ShowDataDTO(account.getData()), account.getMail());
    }
}
