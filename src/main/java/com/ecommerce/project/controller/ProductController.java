package com.ecommerce.project.controller;

import com.ecommerce.project.model.Product;
import com.ecommerce.project.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("api/public/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("api/public/products")
    public String createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return "Product created successfully";
    }

    @DeleteMapping("api/public/products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        try {
            String status = productService.deleteProduct(productId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
