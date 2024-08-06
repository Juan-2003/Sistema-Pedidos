package com.example.pedidos.infra.security;

import com.example.pedidos.entities.Account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        System.out.println("mail: " + mail);
        UserDetails userDetails = accountRepository.findByMail(mail);
        if(userDetails == null){
            System.out.println("Es nulooooo");
        }
        return userDetails;
    }
}
