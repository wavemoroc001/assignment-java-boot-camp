package com.example.assignmentjavabootcamp.services;

import com.example.assignmentjavabootcamp.exceptions.ProductNotFoundException;
import com.example.assignmentjavabootcamp.models.Product;
import com.example.assignmentjavabootcamp.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findProductByContainsName(String name) {
        List<Product> queryResult = productRepository.findByNameContains(name);
        queryResult.forEach(product -> log.info(product.getName()));
        return queryResult;
    }

    public Product findProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            return productOptional.get();
        }
        throw new ProductNotFoundException("Product id : " +id + " was  not found");
    }
}
