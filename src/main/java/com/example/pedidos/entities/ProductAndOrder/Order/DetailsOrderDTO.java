package com.example.pedidos.entities.ProductAndOrder.Order;

import com.example.pedidos.entities.ProductAndOrder.ProductOrder;

import java.util.List;

public record DetailsOrderDTO(
        Long id,
        Long idClient,
        Long idDeliveryman,
        List<ProductOrder> productOrders,
        Double totalPrice
) {
    public DetailsOrderDTO(Order order){
        this(
                order.getId(),
                order.getClient().getId(),
                order.getDeliveryman().getId(),
                order.getProductList(),
                order.getTotalPrice()
        );
    }
}
