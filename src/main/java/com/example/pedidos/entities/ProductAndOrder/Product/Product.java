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
    private Integer price;
    private Boolean available;

    @Override
    public String toString() {
        return "Id=" + id +
                "Name='" + name + '\'' +
                "Description='" + description + '\'' +
                "Price=" + price +
                "Available=" + available;
    }
}
