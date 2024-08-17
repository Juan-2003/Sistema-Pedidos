package com.example.pedidos.entities.Account;

import com.example.pedidos.infra.errors.AccountDuplicated;
import com.example.pedidos.infra.errors.AccountNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public DetailsAccountDTO registerAccount(RegisterAccountDTO registerAccountDTO){
        if(accountRepository.existsByMail(registerAccountDTO.mail())){
            throw new AccountDuplicated("Account with mail: " + registerAccountDTO.mail() + " already exists");
        }
        if(accountRepository.existsByData_PhoneNumber(registerAccountDTO.dataDTO().phoneNumber())){
            throw new AccountDuplicated(
                    "Account with phone number: " + registerAccountDTO.dataDTO().phoneNumber() + " already exists");
        }

        String password = passwordEncoder.encode(registerAccountDTO.password());
        Account account = new Account(registerAccountDTO, password);
        accountRepository.save(account);

        return new DetailsAccountDTO(account);

    }

    public ShowAccountDTO showAccount(Long id){
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new AccountNotFound("The account with id: " + id + " doesn't exist"));
        return new ShowAccountDTO(account);
    }

    public void updateAccount(UpdateAccountDTO updateAccountDTO){
        /*Account account = accountRepository.getReferenceById(updateAccountDTO.id());
        account.update(updateAccountDTO);

        return new DetailsAccountDTO(account);
        */
    }


    public void deleteAccount(Long id){
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFound("The account with id: " + id + " doesn't exist"));

        accountRepository.delete(account);
    }
}
