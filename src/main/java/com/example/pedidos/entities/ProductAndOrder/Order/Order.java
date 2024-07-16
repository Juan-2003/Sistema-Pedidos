package com.example.pedidos.entities.ProductAndOrder.Order;

import com.example.pedidos.entities.Client.Client;
import com.example.pedidos.entities.DeliveryMan.Deliveryman;
import com.example.pedidos.model.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Order")
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private Integer totalPrice;
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryman_id", referencedColumnName = "id")
    private Deliveryman deliveryman;



}
