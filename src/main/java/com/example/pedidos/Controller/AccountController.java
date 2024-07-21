package com.example.pedidos.Controller;

import com.example.pedidos.entities.Account.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<DetallesAccountDTO> registerAccount(@RequestBody @Valid AccountDTO accountDTO, UriComponentsBuilder uriComponentsBuilder){
        DetallesAccountDTO detallesAccountDTO = accountService.registerAccount(accountDTO);

        URI url = uriComponentsBuilder.path("/account/{id}")
                .buildAndExpand(detallesAccountDTO.id())
                .toUri();

        return ResponseEntity.created(url).body(detallesAccountDTO);
    }

    @GetMapping
    public ResponseEntity<List<Account>> mostrarAccounts(){
        return ResponseEntity.ok(accountRepository.findAll());
    }
}
