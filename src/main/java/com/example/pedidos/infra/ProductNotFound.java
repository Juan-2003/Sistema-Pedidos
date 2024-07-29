package com.example.pedidos.infra;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound(String mesaje){
        super(mesaje);
    }
}
