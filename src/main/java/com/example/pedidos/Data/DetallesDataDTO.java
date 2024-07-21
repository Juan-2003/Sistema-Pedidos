package com.example.pedidos.Data;

import com.example.pedidos.entities.Account.Account;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DetallesDataDTO(
        String name,
        String maternalSurName,
        String paternalSurName,
        String address,
        String phoneNumber,
        LocalDate birthday
) {
    public DetallesDataDTO(Data data){
        this(
                data.getName(),
                data.getMaternalSurName(),
                data.getPaternalSurName(),
                data.getAddress(),
                data.getPhoneNumber(),
                data.getBirthday()
        );
    }
}
