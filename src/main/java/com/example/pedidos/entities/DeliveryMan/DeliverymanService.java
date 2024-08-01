package com.example.pedidos.entities.DeliveryMan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliverymanService {
    @Autowired
    private DeliverymanRepository deliverymanRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public DetailsDeliverymanDTO registerDeliveryman(RegisterDeliverymanDTO registerDeliverymanDTO){
        String encodedPassword = passwordEncoder.encode(registerDeliverymanDTO.registerAccountDTO().password());
        Deliveryman deliveryman = new Deliveryman(registerDeliverymanDTO, encodedPassword);
        deliverymanRepository.save(deliveryman);

        return new DetailsDeliverymanDTO(deliveryman);
    }

    public DetailsDeliverymanDTO updateDeliveryman(UpdateDeliverymanDTO updateDeliverymanDTO){
        Deliveryman deliveryman = deliverymanRepository.getReferenceById(updateDeliverymanDTO.id());
        deliveryman.update(updateDeliverymanDTO);

        return new DetailsDeliverymanDTO(deliveryman);

    }

    public boolean deleteDeliveryman(Long id){
        Optional<Deliveryman> deliveryman = deliverymanRepository.findById(id);

        deliveryman.ifPresent(deliverymanRepository::delete);

        return deliveryman.isPresent();
    }
}
