package com.example.pedidos.entities.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public DetailsAccountDTO registerAccount(RegisterAccountDTO registerAccountDTO){
        Account account = new Account(registerAccountDTO);
        accountRepository.save(account);

        return new DetailsAccountDTO(account);

    }

    public void updateAccount(UpdateAccountDTO updateAccountDTO){
        /*Account account = accountRepository.getReferenceById(updateAccountDTO.id());
        account.update(updateAccountDTO);

        return new DetailsAccountDTO(account);
        */
    }


    public boolean deleteAccount(Long id){
        Optional<Account> account = accountRepository.findById(id);

        if(account.isEmpty()){
            return false;
        }
        accountRepository.delete(account.get());
        return true;
    }
}
