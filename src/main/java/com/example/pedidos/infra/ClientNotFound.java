package com.example.pedidos.infra;

public class ClientNotFound extends RuntimeException{
    public ClientNotFound(String mesaje){
        super(mesaje);
    }
}
