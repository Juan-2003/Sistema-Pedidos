package com.example.pedidos.Controller;

import com.example.pedidos.entities.Client.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.management.DescriptorKey;
import java.net.URI;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public ResponseEntity<DetailsClientDTO> registerClient(@RequestBody @Valid RegisterClientDTO registerClientDTO, UriComponentsBuilder uriComponentsBuilder){
        DetailsClientDTO detailsClientDTO = clientService.registerClient(registerClientDTO);

        URI url = uriComponentsBuilder.path("/client/{id}")
                .buildAndExpand(detailsClientDTO.id())
                .toUri();

        return ResponseEntity.created(url).body(detailsClientDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ShowClientDTO>> showClients(Pageable pageable){
        return ResponseEntity.ok(clientRepository.findAll(pageable).map(ShowClientDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowClientDTO> showClient(@PathVariable Long id){
        return ResponseEntity.ok(new ShowClientDTO(clientRepository.getReferenceById(id)));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailsClientDTO> updateClient(@RequestBody @Valid UpdateClientDTO updateClientDTO){
        DetailsClientDTO detailsClientDTO = clientService.updateClient(updateClientDTO);
        return ResponseEntity.ok(detailsClientDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteClient(@PathVariable Long id){
        return (clientService.deleteClient(id))? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
