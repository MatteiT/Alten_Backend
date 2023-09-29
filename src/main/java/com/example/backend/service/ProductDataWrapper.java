package com.example.backend.service;

import com.example.backend.entity.Product;

import java.util.List;

public class ProductDataWrapper {
    private List<Product> data;

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }
}
