package com.example.pedidos.entities.deliveryMan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverymanRepository extends JpaRepository<Deliveryman, Long> {
}
