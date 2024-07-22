package com.example.pedidos.entities.Vehicle;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterVehicleDataDTO(
        @NotNull
        VehicleType vehicleType,
        @NotBlank
        String plates
) {
}
