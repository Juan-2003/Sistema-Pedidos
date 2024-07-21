package com.example.pedidos.Data;

import com.example.pedidos.entities.Account.ShowAccountDTO;

public record ShowDataDTO(
        String name,
        String maternalSurName,
        String paternalSurName,
        String phoneNumber
) {
    public ShowDataDTO(Data data){
        this(data.getName(), data.getMaternalSurName(), data.getPaternalSurName(), data.getPhoneNumber());
    }
}
