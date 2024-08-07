package com.example.pedidos.Controller;

import com.example.pedidos.entities.ProductAndOrder.Product.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<DetailsProductDTO> registerProduct(@RequestBody @Valid RegisterProductDTO registerProductDTO, UriComponentsBuilder uriComponentsBuilder){
        DetailsProductDTO detailsProductDTO = productService.registerProduct(registerProductDTO);

        URI url = uriComponentsBuilder.path("/product/{id}")
                .buildAndExpand(detailsProductDTO.id())
                .toUri();

        return ResponseEntity.created(url).body(detailsProductDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ShowProductDTO>> showProducts(Pageable pageable){
        return ResponseEntity.ok(productRepository.findAll(pageable).map(ShowProductDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowProductDTO> showProduct(@PathVariable Long id){
        ShowProductDTO showProductDTO = productService.showProductDTO(id);
        return ResponseEntity.ok(showProductDTO);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailsProductDTO> updateProduct(@RequestBody @Valid UpdateProductDTO updateProductDTO){
        DetailsProductDTO detailsProductDTO = productService.updateProduct(updateProductDTO);
        return ResponseEntity.ok(detailsProductDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }



}
