package com.example.pedidos.entities.DeliveryMan;

import com.example.pedidos.entities.Vehicle.VehicleDataDTO;
import com.example.pedidos.entities.Account.RegisterAccountDTO;
import com.example.pedidos.Data.DataDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record RegisterDeliverymanDTO(
        @NotNull
        @JsonAlias("data") DataDTO dataDTO,

        @NotNull
        @JsonAlias("account") RegisterAccountDTO registerAccountDTO,

        @NotNull
        @JsonAlias("vehicleData") VehicleDataDTO vehicleDataDTO

){
}
