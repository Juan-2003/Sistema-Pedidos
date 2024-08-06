package com.example.pedidos.infra.security;

public record JWTDataDTO(
        String jwtToken
) {
    public JWTDataDTO(String jwtToken){
        this.jwtToken = jwtToken;
    }
}
