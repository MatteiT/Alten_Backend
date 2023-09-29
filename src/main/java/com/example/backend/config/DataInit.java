package com.example.backend.config;

import com.example.backend.entity.Product;
import com.example.backend.repository.ProductRepository;
import com.example.backend.service.ProductDataWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// The DataInit class is used to initialize the database with data from the products.json file.
@Component
public class DataInit {

    private final ProductRepository productRepository;

    public DataInit(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // This method is executed to initialize the database with data from the products.json file.
    @PostConstruct
    public void init() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // The products.json file is located in the src/main/resources/json directory.
            InputStream inputStream = getClass().getResourceAsStream("/json/products.json");
            // The ProductDataWrapper class is used to deserialize the JSON data into a list of Product objects.
            ProductDataWrapper wrapper = objectMapper.readValue(inputStream, ProductDataWrapper.class);
            // The list of Product objects is saved to the database.
            List<Product> products = wrapper.getData();
            productRepository.saveAll(products);
        } catch (IOException e) {
            System.out.println("Unable to save products: " + e.getMessage());
        }
    }
}
