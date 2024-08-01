package com.example.pedidos.infra.errors;

public class ClientNotFound extends RuntimeException{
    public ClientNotFound(String mesaje){
        super(mesaje);
    }
}
