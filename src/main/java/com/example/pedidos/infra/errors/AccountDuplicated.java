package com.example.pedidos.infra.errors;

public class AccountDuplicated extends RuntimeException{
    public AccountDuplicated(String mesaje){
        super(mesaje);
    }
}

