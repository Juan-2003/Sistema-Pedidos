package com.example.pedidos.entities.DeliveryMan;

import com.example.pedidos.entities.ProductAndOrder.Order.Order;
import com.example.pedidos.entities.Vehicle.RegisterVehicleDataDTO;
import com.example.pedidos.entities.Vehicle.VehicleData;
import com.example.pedidos.entities.Account.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Deliveryman")
@Table(name = "deliveryman")
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

    @OneToOne(mappedBy = "deliveryman")
    private Order order;

    private Boolean available;

    public Deliveryman(RegisterDeliverymanDTO registerDeliverymanDTO, String encodedPassword){
        this.account = new Account(registerDeliverymanDTO.registerAccountDTO(), encodedPassword);
        this.vehicleData = new VehicleData(registerDeliverymanDTO.registerVehicleDataDTO());
        this.available = true;
    }

    public void setAvailable(Boolean available){
        this.available = available;
    }

    public void update(UpdateDeliverymanDTO updateDeliverymanDTO){
        account.update(updateDeliverymanDTO.updateAccountDTO());
        vehicleData.update(updateDeliverymanDTO.updateVehicleDataDTO());
    }

}
