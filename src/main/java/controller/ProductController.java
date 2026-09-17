package com.layered.backend.controller;

import com.layered.backend.domain.Product;
import com.layered.backend.dto.ProductRequest;
import com.layered.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product createProduct(@RequestBody ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setBrand(request.getBrand());
        product.setCategory(request.getCategory());
        product.setIngredients(request.getIngredients());
        product.setDescription(request.getDescription());
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}