package com.example.pedidos.infra.errors;

import com.example.pedidos.entities.ProductAndOrder.Order.OrderService;

public class OrderNotFound extends RuntimeException{
    public OrderNotFound(String mesaje){
        super(mesaje);
    }
}
