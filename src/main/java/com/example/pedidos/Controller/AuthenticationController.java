package com.example.pedidos.Controller;

import com.example.pedidos.entities.Account.Account;
import com.example.pedidos.infra.security.AuthenticateDataDTO;
import com.example.pedidos.infra.security.JWTDataDTO;
import com.example.pedidos.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log-in")
public class AuthenticationController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<JWTDataDTO> userAuthentication(@RequestBody AuthenticateDataDTO authenticateDataDTO){
        System.out.println(1);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                authenticateDataDTO.mail(), authenticateDataDTO.password());
        System.out.println(3);
        var authenticateUser = authenticationManager.authenticate(authToken);
        System.out.println(4);
        var JWTtoken = tokenService.generateToken((Account) authenticateUser.getPrincipal());
        System.out.println(5);
        return ResponseEntity.ok(new JWTDataDTO(JWTtoken));
    }
}
