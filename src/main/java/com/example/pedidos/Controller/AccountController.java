package com.example.pedidos.Controller;

import com.example.pedidos.entities.Account.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<DetailsAccountDTO> registerAccount(@RequestBody @Valid RegisterAccountDTO registerAccountDTO, UriComponentsBuilder uriComponentsBuilder){
        DetailsAccountDTO detailsAccountDTO = accountService.registerAccount(registerAccountDTO);

        URI url = uriComponentsBuilder.path("/account/{id}")
                .buildAndExpand(detailsAccountDTO.id())
                .toUri();

        return ResponseEntity.created(url).body(detailsAccountDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ShowAccountDTO>> showAccounts(Pageable pageable){
        return ResponseEntity.ok(accountRepository.findAll(pageable).map(ShowAccountDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowAccountDTO> showAccount(@PathVariable Long id){
        ShowAccountDTO showAccountDTO = accountService.showAccount(id);
        return ResponseEntity.ok(showAccountDTO);
    }

    @PutMapping
    @Transactional
    public void updateAccount(@RequestBody @Valid UpdateAccountDTO updateAccountDTO){
        /*DetailsAccountDTO detailsAccountDTO = accountService.updateAccount(updateAccountDTO);
        return ResponseEntity.ok(detailsAccountDTO);*/
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteAccount(@PathVariable Long id){
        if(accountService.deleteAccount(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
