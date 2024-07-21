package com.example.pedidos.entities.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public DetailsAccountDTO registerAccount(AccountDTO accountDTO){
        Account account = new Account(accountDTO);
        accountRepository.save(account);

        return new DetailsAccountDTO(account);

    }
}
