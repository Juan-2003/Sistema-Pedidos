package com.example.pedidos.entities.DeliveryMan;

import com.example.pedidos.entities.Vehicle.VehicleData;
import com.example.pedidos.entities.Account.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Deliveryman")
@Table(name = "delivery_man")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Deliveryman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_data_id", referencedColumnName = "id")
    private VehicleData vehicleData;

    //Hace falta la llave foranea de la orden

}
