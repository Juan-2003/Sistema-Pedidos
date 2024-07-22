package com.example.pedidos.entities.DeliveryMan;

import com.example.pedidos.entities.Account.ShowAccountDTO;
import com.example.pedidos.entities.Vehicle.ShowVehicleData;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ShowDeliverymanDTO(
        Long id,
        @JsonProperty("account") ShowAccountDTO showAccountDTO,
        @JsonProperty("vehicleData")  ShowVehicleData showVehicleData
) {
    public ShowDeliverymanDTO(Deliveryman deliveryman){
        this(
                deliveryman.getId(),
                new ShowAccountDTO(deliveryman.getAccount()),
                new ShowVehicleData(deliveryman.getVehicleData())
        );
    }
}
