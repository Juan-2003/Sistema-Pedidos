package com.example.pedidos.entities.DeliveryMan;

import com.example.pedidos.entities.Account.DetailsAccountDTO;
import com.example.pedidos.entities.Vehicle.DetailsVehicleDTO;
import com.example.pedidos.entities.Vehicle.RegisterVehicleDataDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"deliverymanId", "account", "vehicleData"})
public record DetailsDeliverymanDTO(
        @JsonProperty("deliverymanId") Long id,
        @JsonProperty("account") DetailsAccountDTO detailsAccountDTO,
        @JsonAlias("vehicleData") DetailsVehicleDTO detailsVehicleDTO

) {
    public DetailsDeliverymanDTO(Deliveryman deliveryman){
        this(
                deliveryman.getId(),
                new DetailsAccountDTO(deliveryman.getAccount()),
                new DetailsVehicleDTO(deliveryman.getVehicleData())
        );
    }
}
