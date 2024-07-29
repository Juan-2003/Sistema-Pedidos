package com.example.pedidos.infra;

public class DeliverymanNotAvailable extends RuntimeException{
    public DeliverymanNotAvailable(String mesaje){
        super(mesaje);
    }
}
