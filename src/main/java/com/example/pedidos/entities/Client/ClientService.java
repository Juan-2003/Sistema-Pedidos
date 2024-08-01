package com.example.pedidos.entities.Client;

import com.example.pedidos.entities.Account.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public DetailsClientDTO registerClient(RegisterClientDTO registerClientDTO) {
        String encodedPassword = passwordEncoder.encode(registerClientDTO.registerAccountDTO().password());
        Client client = new Client(registerClientDTO, encodedPassword);
        clientRepository.save(client);

        return new DetailsClientDTO(client);
    }

    public DetailsClientDTO updateClient(UpdateClientDTO updateClientDTO){
        Client client = clientRepository.getReferenceById(updateClientDTO.id());
        client.update(updateClientDTO);

        return new DetailsClientDTO(client);

    }

    public boolean deleteClient(Long id){
        Optional<Client> client = clientRepository.findById(id);

        client.ifPresent(clientRepository::delete);

        return client.isPresent();
    }

}
