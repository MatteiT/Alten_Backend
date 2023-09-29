package com.example.backend.controller;

import com.example.backend.entity.Product;
import com.example.backend.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// The @CrossOrigin annotation is used to enable cross-origin requests from the Angular application.
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        // The product object is wrapped in a ResponseEntity object and returned or a 404 Not Found HTTP status code is returned.
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody @Valid Product product) {
        return productRepository.save(product);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            // The productToUpdate object is updated with the values from the updatedProduct object.
            Product productToUpdate = optionalProduct.get();
            productToUpdate.setCode(updatedProduct.getCode());
            productToUpdate.setName(updatedProduct.getName());
            productToUpdate.setDescription(updatedProduct.getDescription());
            productToUpdate.setPrice(updatedProduct.getPrice());
            productToUpdate.setQuantity(updatedProduct.getQuantity());
            productToUpdate.setInventoryStatus(updatedProduct.getInventoryStatus());
            productToUpdate.setCategory(updatedProduct.getCategory());
            productToUpdate.setImage(updatedProduct.getImage());
            productToUpdate.setRating(updatedProduct.getRating());
            return ResponseEntity.ok(productRepository.save(productToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            // The ResponseEntity.noContent() method returns a 204 No Content HTTP status code if the product is deleted successfully.
            return ResponseEntity.noContent().build();
        } else {
            // The ResponseEntity.notFound() method returns a 404 Not Found HTTP status code if the product is not found.
            return ResponseEntity.notFound().build();
        }
    }
}

