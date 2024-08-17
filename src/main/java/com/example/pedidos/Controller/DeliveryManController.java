package com.example.pedidos.Controller;

import com.example.pedidos.entities.DeliveryMan.*;
import com.example.pedidos.entities.Vehicle.ShowVehicleData;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/deliveryman")
public class DeliveryManController {
    @Autowired
    private DeliverymanRepository deliverymanRepository;

    @Autowired
    private DeliverymanService deliverymanService;

    @PostMapping
    public ResponseEntity<DetailsDeliverymanDTO> registerDeliveryMan(@RequestBody @Valid RegisterDeliverymanDTO registerDeliverymanDTO, UriComponentsBuilder uriComponentsBuilder){
        DetailsDeliverymanDTO detailsDeliverymanDTO = deliverymanService.registerDeliveryman(registerDeliverymanDTO);

        URI url = uriComponentsBuilder.path("/deliveryman/{id}")
                .buildAndExpand(detailsDeliverymanDTO.id())
                .toUri();

        return ResponseEntity.created(url).body(detailsDeliverymanDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ShowDeliverymanDTO>> showDeliverymans(Pageable pageable){
        return ResponseEntity.ok(deliverymanRepository.findAll(pageable).map(ShowDeliverymanDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowDeliverymanDTO> showDeliveryman(@PathVariable Long id){
        ShowDeliverymanDTO showDeliverymanDTO = deliverymanService.showDeliveryman(id);
        return ResponseEntity.ok(showDeliverymanDTO);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailsDeliverymanDTO> updateDeliveryman(@RequestBody @Valid UpdateDeliverymanDTO updateDeliverymanDTO){
        DetailsDeliverymanDTO detailsDeliverymanDTO = deliverymanService.updateDeliveryman(updateDeliverymanDTO);
        return ResponseEntity.ok(detailsDeliverymanDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteDeliveryman(@PathVariable Long id){
        deliverymanService.deleteDeliveryman(id);
        return ResponseEntity.noContent().build();

    }
}
