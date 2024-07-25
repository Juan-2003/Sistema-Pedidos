package com.example.pedidos.Controller;

import com.example.pedidos.entities.ProductAndOrder.Order.DetailsOrderDTO;
import com.example.pedidos.entities.ProductAndOrder.Order.OrderRepository;
import com.example.pedidos.entities.ProductAndOrder.Order.OrderService;
import com.example.pedidos.entities.ProductAndOrder.Order.RegisterOrderDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<DetailsOrderDTO> registerOrder(@RequestBody @Valid RegisterOrderDTO registerOrderDTO, UriComponentsBuilder uriComponentsBuilder){
        DetailsOrderDTO detailsOrderDTO = orderService.registerOrder(registerOrderDTO);

        URI url = uriComponentsBuilder.path("/order/{id}")
                .buildAndExpand(detailsOrderDTO.id())
                .toUri();
        return ResponseEntity.created(url).body(detailsOrderDTO);
    }
}
