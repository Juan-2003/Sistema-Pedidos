package com.example.pedidos.Data;

import java.time.LocalDate;

public record DetailsDataDTO(
        String name,
        String maternalSurName,
        String paternalSurName,
        String address,
        String phoneNumber,
        LocalDate birthday
) {
    public DetailsDataDTO(Data data){
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
