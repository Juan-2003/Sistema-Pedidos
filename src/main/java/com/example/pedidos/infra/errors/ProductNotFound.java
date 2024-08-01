package com.example.pedidos.infra.errors;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound(String mesaje){
        super(mesaje);
    }
}
