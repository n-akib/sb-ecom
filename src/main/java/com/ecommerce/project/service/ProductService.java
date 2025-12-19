package com.ecommerce.project.service;

import com.ecommerce.project.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void createProduct(Product product);
    String deleteProduct(Long productId);
}
