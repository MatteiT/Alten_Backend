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

@Component
public class DataInit {

    private final ProductRepository productRepository;

    public DataInit(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/json/products.json");
            ProductDataWrapper wrapper = objectMapper.readValue(inputStream, ProductDataWrapper.class);
            List<Product> products = wrapper.getData();
            productRepository.saveAll(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
