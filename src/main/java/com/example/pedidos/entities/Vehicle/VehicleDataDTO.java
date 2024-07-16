package com.example.pedidos.entities.Vehicle;

import com.example.pedidos.entities.Vehicle.Vehicle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleDataDTO(
        @NotNull
        Vehicle vehicleType,
        @NotBlank
        String plates
) {
}
