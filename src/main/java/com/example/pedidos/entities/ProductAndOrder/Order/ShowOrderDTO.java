package com.example.pedidos.entities.ProductAndOrder.Order;

import com.example.pedidos.entities.ProductAndOrder.Product.DetailsProductDTO;
import com.example.pedidos.entities.ProductAndOrder.Product.ShowProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.stream.Collectors;

@JsonPropertyOrder({"idOrder", "idClient", "idDeliveryman", "totalPrice", "Products"})
public record ShowOrderDTO(
        @JsonProperty("idOrder") Long id,
        Long idClient,
        Long idDeliveryman,
        Double totalPrice,
        @JsonProperty("Products") List<ShowProductDTO> productOrders
) {
    public ShowOrderDTO(Order order){
        this(
                order.getId(),
                order.getClient().getId(),
                order.getDeliveryman().getId(),
                order.getTotalPrice(),
                order.getProductOrderList().stream()
                        .map(productOrder -> new ShowProductDTO(productOrder.getProduct()))
                        .collect(Collectors.toList())
        );
    }
}
