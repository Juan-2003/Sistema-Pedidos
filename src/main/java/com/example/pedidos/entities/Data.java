package com.example.pedidos.entities;

import com.example.pedidos.entities.Account.Account;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Embeddable
public class Data{
    private String name;
    private String maternalSurName;
    private String paternalSurName;
    private String address;
    private String phoneNumber;
    private LocalDate birthday;

    //Tarjeta de debito o credito

    public Data(){}

    public Data(String name, String maternalSurName, String paternalSurName,
                String address, String phoneNumber, LocalDate birthday){
        this.name = name;
        this.maternalSurName = maternalSurName;
        this.paternalSurName = paternalSurName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return  "Name='" + name + '\'' +
                "MaternalSurName='" + maternalSurName + '\'' +
                "PaternalSurName='" + paternalSurName + '\'' +
                "Address='" + address + '\'' +
                "PhoneNumber='" + phoneNumber + '\'' +
                "Birthday=" + birthday;
    }
}
