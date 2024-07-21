package com.example.pedidos.Data;

import com.example.pedidos.entities.Account.Account;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Embeddable
public class Data{
    private String name;

    @Column(name = "maternal_sur_name")
    private String maternalSurName;

    @Column(name = "paternal_sur_name")
    private String paternalSurName;

    private String address;

    @Column(name = "phone_number")
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

    public Data(DataDTO dataDTO){
        this.name = dataDTO.name();
        this.paternalSurName = dataDTO.paternalSurName();
        this.maternalSurName = dataDTO.maternalSurName();
        this.address = dataDTO.address();
        this.phoneNumber = dataDTO.phoneNumber();
        this.birthday = dataDTO.birthday();
    }

    public void update(UpdateDataDTO updateDataDTO){
        if(updateDataDTO.name() != null){
            this.name = updateDataDTO.name();
        }
        if(updateDataDTO.maternalSurName() != null){
            this.maternalSurName = updateDataDTO.maternalSurName();
        }
        if(updateDataDTO.paternalSurName() != null){
            this.paternalSurName = updateDataDTO.paternalSurName();
        }
        if(updateDataDTO.address() != null){
            this.address = updateDataDTO.address();
        }
        if(updateDataDTO.phoneNumber() != null){
            this.phoneNumber = updateDataDTO.phoneNumber();
        }
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
