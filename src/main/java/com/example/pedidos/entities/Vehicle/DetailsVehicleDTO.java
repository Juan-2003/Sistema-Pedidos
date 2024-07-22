package com.example.pedidos.entities.Vehicle;


public record DetailsVehicleDTO(
        VehicleType vehicleType,
        String plates
) {
    public DetailsVehicleDTO(VehicleData vehicleData){
        this(
                vehicleData.getVehicleType(),
                vehicleData.getPlates()
        );
    }
}
