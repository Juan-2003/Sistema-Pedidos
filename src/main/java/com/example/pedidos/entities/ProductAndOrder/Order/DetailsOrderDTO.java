package com.example.pedidos.entities.ProductAndOrder.Order;

import com.example.pedidos.entities.ProductAndOrder.Product.DetailsProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.stream.Collectors;

@JsonPropertyOrder({"idOrder", "idClient", "idDeliveryman", "totalPrice", "Products"})
public record DetailsOrderDTO(
        @JsonProperty("idOrder") Long id,
        Long idClient,
        Long idDeliveryman,
        Double totalPrice,
        OrderStatus orderStatus,
        @JsonProperty("Products") List<DetailsProductDTO> productOrders
) {
    public DetailsOrderDTO(Order order){
        this(
                order.getId(),
                order.getClient().getId(),
                order.getDeliveryman().getId(),
                order.getTotalPrice(),
                order.getOrderStatus(),
                order.getProductOrderList().stream()
                        .map(productOrder -> new DetailsProductDTO(productOrder.getProduct()))
                        .collect(Collectors.toList())
        );
    }
}
