package com.example.pedidos.Controller;

import com.example.pedidos.entities.Account.AccountDTO;
import com.example.pedidos.entities.Account.AccountRepository;
import com.example.pedidos.entities.Account.AccountRole;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping
    public void registerAccount(@RequestBody @Valid AccountDTO accountDTO){
        System.out.println(AccountRole.fromString(accountDTO.role()));
        System.out.println(accountDTO);
    }
}
