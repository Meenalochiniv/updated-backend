package com.example.controller;


import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
 
import com.example.entity.Product;

import com.example.service.ProductService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("/get")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }


        @PostMapping("/{vendorId}")
        public ResponseEntity<Product> addProduct(@PathVariable Long vendorId, @RequestBody Product product) {
            Product newProduct = productService.addProduct(vendorId, product);
            if (newProduct != null) {
                return ResponseEntity.ok(newProduct);
            } else {
                return ResponseEntity.notFound().build(); // Vendor not found
            }
        }
    
    @PutMapping("/{productId}")

    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product productDetails) {

        Product updatedProduct = productService.updateProduct(productId, productDetails);

        if (updatedProduct != null) {

            return ResponseEntity.ok(updatedProduct);

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 

    }

    @DeleteMapping("/{productId}")

    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {

        productService.deleteProduct(productId);

        return ResponseEntity.ok("Product deleted successfully!");

    }

    
    @GetMapping("/vendor/{vendorId}")

    public ResponseEntity<List<Product>> getProductsByVendor(@PathVariable Long vendorId) {

        List<Product> products = productService.getProductsByVendor(vendorId);

        return ResponseEntity.ok(products);

    }

}

 