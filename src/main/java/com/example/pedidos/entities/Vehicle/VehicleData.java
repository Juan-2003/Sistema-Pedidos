package com.example.pedidos.entities.Vehicle;

import com.example.pedidos.entities.Vehicle.Vehicle;
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
    private Vehicle vehicleType;
    private String plates;

    @Override
    public String toString() {
        return "Id=" + id +
                "VehicleType=" + vehicleType +
                "Plates='" + plates;
    }
}
