package com.example.pedidos.infra;

import com.example.pedidos.entities.ProductAndOrder.Order.OrderService;

public class OrderNotFound extends RuntimeException{
    public OrderNotFound(String mesaje){
        super(mesaje);
    }
}
