package com.example.pedidos.Controller;

import com.example.pedidos.entities.deliveryMan.DeliverymanRepository;
import com.example.pedidos.entities.deliveryMan.RegisterDeliverymanDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliveryman")
public class DeliveryManController {
    @Autowired
    private DeliverymanRepository deliverymanRepository;

    @PostMapping
    public void registerDeliveryMan(@RequestBody @Valid RegisterDeliverymanDTO registerDeliverymanDTO){
        System.out.println(registerDeliverymanDTO);
    }
}
