package com.example.pedidos.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.pedidos.entities.Account.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Value("${api.security.secret}")
    private String jwtPassword;

    public String generateToken(Account account){
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtPassword);
            String token = JWT.create()
                    .withIssuer("aplication")
                    .withSubject(account.getMail())
                    .withClaim("id", account.getId())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new JWTCreationException("Error JWT token", exception);
        }
    }
}
