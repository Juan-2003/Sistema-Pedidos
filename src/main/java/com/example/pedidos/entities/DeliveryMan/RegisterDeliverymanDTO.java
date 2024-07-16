package com.example.pedidos.entities.DeliveryMan;

import com.example.pedidos.entities.Vehicle.VehicleDataDTO;
import com.example.pedidos.entities.Account.AccountDTO;
import com.example.pedidos.entities.DataDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record RegisterDeliverymanDTO(
        @NotNull
        @JsonAlias("data") DataDTO dataDTO,

        @NotNull
        @JsonAlias("account") AccountDTO accountDTO,

        @NotNull
        @JsonAlias("vehicleData") VehicleDataDTO vehicleDataDTO

){
}
