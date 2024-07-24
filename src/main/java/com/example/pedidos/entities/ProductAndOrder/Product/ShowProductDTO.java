package com.example.pedidos.entities.ProductAndOrder.Product;

public record ShowProductDTO(
        Long id,
        String name,
        String description,
        Double price
) {
    public ShowProductDTO(Product product){
        this(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
