package com.example.pedidos.infra.security;

public record AuthenticateDataDTO(
        String mail,
        String password
) {
}
