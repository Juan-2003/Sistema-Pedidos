package com.example.pedidos.entities.Vehicle;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateVehicleDataDTO(
        @NotNull
        VehicleType vehicleType,
        @NotBlank
        String plates
) {
}
