package com.example.pedidos.entities.ProductAndOrder.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetailsProductDTO(
        Long id,
        String name,
        String description,
        Double price
) {
        public DetailsProductDTO(Product product){
                this(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()
                );
        }
}
