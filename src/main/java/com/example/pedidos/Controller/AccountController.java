package com.example.pedidos.Controller;

import com.example.pedidos.entities.Account.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<DetailsAccountDTO> registerAccount(@RequestBody @Valid AccountDTO accountDTO, UriComponentsBuilder uriComponentsBuilder){
        DetailsAccountDTO detailsAccountDTO = accountService.registerAccount(accountDTO);

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
        return ResponseEntity.ok(new ShowAccountDTO(accountRepository.getReferenceById(id)));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailsAccountDTO> updateAccount(@RequestBody @Valid UpdateAccountDTO updateAccountDTO){
        DetailsAccountDTO detailsAccountDTO = accountService.updateAcconunt(updateAccountDTO);
        return ResponseEntity.ok(detailsAccountDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteAccount(@PathVariable Long id){
        if(accountService.deleteAccount(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }


}
