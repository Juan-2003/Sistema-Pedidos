package com.example.pedidos.entities.Client;

import com.example.pedidos.entities.Account.Account;
import com.example.pedidos.entities.ProductAndOrder.Order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.sql.Update;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Client")
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToMany(mappedBy = "client")
    private List<Order> orderList = new ArrayList<>();

    Client(RegisterClientDTO registerClientDTO, String encodedPassword){
        this.account = new Account(registerClientDTO.registerAccountDTO(), encodedPassword);
    }

    public void update(UpdateClientDTO updateClientDTO){
        if(updateClientDTO.updateAccountDTO() != null){
            account.update(updateClientDTO.updateAccountDTO());
        }
    }

}
