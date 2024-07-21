package com.example.pedidos.entities.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public DetallesAccountDTO registerAccount(AccountDTO accountDTO){
        Account account = new Account(accountDTO);
        accountRepository.save(account);

        return new DetallesAccountDTO(account);

    }
}
