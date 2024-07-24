package com.example.pedidos.entities.ProductAndOrder.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Product")
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Boolean available;


    public Product(RegisterProductDTO registerProductDTO){
        this.name = registerProductDTO.name();
        this.description = registerProductDTO.description();
        this.price = registerProductDTO.price();
        this.available = false;
    }

    public void update(UpdateProductDTO updateProductDTO){
        if(updateProductDTO.name() != null && updateProductDTO.name() != this.name){
            this.name = updateProductDTO.name();
        }
        if(updateProductDTO.description() != null && updateProductDTO.description() != this.description){
            this.description = updateProductDTO.description();
        }
        if(updateProductDTO.price() != null && updateProductDTO.price() != this.price){
            this.price = updateProductDTO.price();
        }
    }

    @Override
    public String toString() {
        return "Id=" + id +
                "Name='" + name + '\'' +
                "Description='" + description + '\'' +
                "Price=" + price +
                "Available=" + available;
    }
}
