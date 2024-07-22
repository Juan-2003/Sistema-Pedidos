package com.example.pedidos.entities.DeliveryMan;

import com.example.pedidos.entities.Account.UpdateAccountDTO;
import com.example.pedidos.entities.Vehicle.UpdateVehicleDataDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record UpdateDeliverymanDTO(
        @NotNull
        @JsonProperty("deliverymanId") Long id,
        @NotNull
        @JsonProperty("account") UpdateAccountDTO updateAccountDTO,
        @NotNull
        @JsonProperty("vehicleData") UpdateVehicleDataDTO updateVehicleDataDTO
) {
}
