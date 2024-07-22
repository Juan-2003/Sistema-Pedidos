package com.example.pedidos.entities.DeliveryMan;

import com.example.pedidos.entities.Vehicle.RegisterVehicleDataDTO;
import com.example.pedidos.entities.Account.RegisterAccountDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record RegisterDeliverymanDTO(
        @NotNull
        @JsonAlias("account") RegisterAccountDTO registerAccountDTO,

        @NotNull
        @JsonAlias("vehicleData") RegisterVehicleDataDTO registerVehicleDataDTO

){
}
