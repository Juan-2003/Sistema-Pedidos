package com.example.pedidos.Controller;

import com.example.pedidos.entities.ProductAndOrder.Order.*;
import com.example.pedidos.entities.ProductAndOrder.Product.ShowProductDTO;
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

    @GetMapping
    public ResponseEntity<Page<ShowOrderDTO>> showOrders(Pageable pageable){
        return ResponseEntity.ok(orderRepository.findAll(pageable).map(ShowOrderDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowOrderDTO> showOrder(@PathVariable Long id){
        return ResponseEntity.ok(new ShowOrderDTO(orderRepository.getReferenceById(id)));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailsOrderDTO> updateOrder(@RequestBody @Valid UpdateOrderDTO updateOrderDTO){
        DetailsOrderDTO detailsOrderDTO = orderService.updateOrder(updateOrderDTO);
        return ResponseEntity.ok(detailsOrderDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteOrder(@PathVariable Long id){
        return (orderService.deleteOrder(id))? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }


}
