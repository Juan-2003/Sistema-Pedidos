package com.example.pedidos.infra.errors;

public class DeliverymanNotAvailable extends RuntimeException{
    public DeliverymanNotAvailable(String mesaje){
        super(mesaje);
    }
}
