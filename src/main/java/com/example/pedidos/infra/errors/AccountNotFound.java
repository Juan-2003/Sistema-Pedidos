package com.example.pedidos.infra.errors;

public class AccountNotFound extends RuntimeException{
    public AccountNotFound(String mesaje){
        super(mesaje);
    }
}
