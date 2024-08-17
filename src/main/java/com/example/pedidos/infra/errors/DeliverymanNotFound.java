package com.example.pedidos.infra.errors;

public class DeliverymanNotFound extends RuntimeException{
    public DeliverymanNotFound(String mesaje){
        super(mesaje);
    }
}
