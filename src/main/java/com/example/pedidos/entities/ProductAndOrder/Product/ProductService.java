package com.example.pedidos.entities.ProductAndOrder.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public DetailsProductDTO registerProduct(RegisterProductDTO registerProductDTO){
        Product product = new Product(registerProductDTO);
        productRepository.save(product);

        return new DetailsProductDTO(product);
    }

    public DetailsProductDTO updateProduct(UpdateProductDTO updateProductDTO){
        Product product = productRepository.getReferenceById(updateProductDTO.id());
        product.update(updateProductDTO);

        return new DetailsProductDTO(product);
    }

    public Boolean deleteProduct(Long id){
        Optional<Product> product = productRepository.findById(id);

        product.ifPresent(productRepository::delete);

        return product.isPresent();
    }
}
