package com.example.pedidos.entities.Vehicle;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "VehicleData")
@Table(name = "vehicle_data")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class VehicleData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    private String plates;

    public VehicleData(RegisterVehicleDataDTO vehicleDataDTO){
        this.vehicleType = VehicleType.fromString(vehicleDataDTO.vehicleType().toString());
        this.plates = vehicleDataDTO.plates();
    }

    public void update(UpdateVehicleDataDTO updateVehicleDataDTO){
        if(updateVehicleDataDTO.vehicleType() != null && updateVehicleDataDTO.vehicleType() != this.vehicleType){
            this.vehicleType = updateVehicleDataDTO.vehicleType();
        }
        if(updateVehicleDataDTO.plates() != null && updateVehicleDataDTO.plates() != this.plates){
            this.plates = updateVehicleDataDTO.plates();
        }
    }

    @Override
    public String toString() {
        return "Id=" + id +
                "VehicleType=" + vehicleType +
                "Plates='" + plates;
    }
}
