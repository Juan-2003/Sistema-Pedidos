package com.example.pedidos.entities.Client;

import com.example.pedidos.entities.Account.ShowAccountDTO;
import com.example.pedidos.entities.ProductAndOrder.Order.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"clientId", "account", "orderList"})
public record ShowClientDTO(
        @JsonProperty("clientId")Long id,
        @JsonProperty("account")ShowAccountDTO showAccountDTO,
        List<Order> orderList
) {
    public ShowClientDTO(Client client){
        this(
                client.getId(),
                new ShowAccountDTO(client.getAccount()),
                client.getOrderList()
                );
    }
}
