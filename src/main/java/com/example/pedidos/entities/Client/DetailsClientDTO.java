package com.example.pedidos.entities.Client;

import com.example.pedidos.entities.Account.DetailsAccountDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public record DetailsClientDTO(
        @JsonProperty("clientId")Long id,
        @JsonProperty("account")DetailsAccountDTO detailsAccountDTO
) {
     DetailsClientDTO(Client client){
        this(client.getId(), new DetailsAccountDTO(client.getAccount()));
    }
}
