package com.example.pedidos.entities.Vehicle;

import com.example.pedidos.entities.Account.ShowAccountDTO;

public record ShowVehicleData(
        VehicleType vehicleType,
        String plates
) {
    public ShowVehicleData(VehicleData vehicleData){
        this(
                vehicleData.getVehicleType(),
                vehicleData.getPlates()
        );
    }
}
