package com.example.pedidos.entities.ProductAndOrder.Order;

import com.example.pedidos.entities.Client.Client;
import com.example.pedidos.entities.DeliveryMan.Deliveryman;
import com.example.pedidos.entities.ProductAndOrder.ProductOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Order")
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryman_id", referencedColumnName = "id")
    private Deliveryman deliveryman;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ProductOrder> productOrderList = new ArrayList<>();

    public Order(Client client, Deliveryman deliveryman){
        this.client = client;
        this.deliveryman = deliveryman;
        this.orderStatus = OrderStatus.PENDING;
    }

    public void updateOrderStatus(UpdateOrderDTO updateOrderDTO){
        if(updateOrderDTO.orderStatus() != this.orderStatus){
            this.orderStatus = updateOrderDTO.orderStatus();
        }
    }



    public void calculateTotalPrice(){
        if(productOrderList.isEmpty()){
            return;
        }

        this.totalPrice = 0.0;
        for(ProductOrder productOrder : productOrderList){
            totalPrice += productOrder.getProduct().getPrice();
        }
        /*this.totalPrice = productList.stream()
                .map(p -> p.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add)
        */
    }
}
