package com.example.pedidos.entities.ProductAndOrder.Product;

import com.example.pedidos.infra.errors.ProductNotFound;
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

    public ShowProductDTO showProductDTO(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("Product with id: "+ id +" doesn´t exist"));
        return new ShowProductDTO(product);

    }

    public DetailsProductDTO updateProduct(UpdateProductDTO updateProductDTO){
        Product product = productRepository.getReferenceById(updateProductDTO.id());
        product.update(updateProductDTO);

        return new DetailsProductDTO(product);
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("Product with id: " + id + " doesn´t exist"));

        productRepository.delete(product);
    }
}
