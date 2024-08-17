package com.example.pedidos.entities.DeliveryMan;

import com.example.pedidos.infra.errors.DeliverymanNotFound;
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

    public ShowDeliverymanDTO showDeliveryman(Long id){
        Deliveryman deliveryman = deliverymanRepository.findById(id)
                .orElseThrow(() -> new DeliverymanNotFound("Deliveryman with id " + id + " doesn´t exist"));

        return new ShowDeliverymanDTO(deliveryman);
    }

    public DetailsDeliverymanDTO updateDeliveryman(UpdateDeliverymanDTO updateDeliverymanDTO){
        Deliveryman deliveryman = deliverymanRepository.getReferenceById(updateDeliverymanDTO.id());
        deliveryman.update(updateDeliverymanDTO);

        return new DetailsDeliverymanDTO(deliveryman);

    }

    public void deleteDeliveryman(Long id){
        Deliveryman deliveryman = deliverymanRepository.findById(id)
                .orElseThrow(() -> new DeliverymanNotFound("Deliveryman with id " + id + " doesn´t exist"));

        deliverymanRepository.delete(deliveryman);
    }
}
