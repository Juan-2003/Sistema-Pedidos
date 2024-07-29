package com.example.pedidos.entities.DeliveryMan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliverymanRepository extends JpaRepository<Deliveryman, Long> {
    @Query(
            """
            SELECT d 
            FROM Deliveryman d
            WHERE d.available = true
            ORDER BY RAND()
            LIMIT 1
            """
    )
    Optional<Deliveryman> foundAvailableDeliveryman();
}
