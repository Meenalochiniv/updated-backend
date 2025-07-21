package com.example.feignclient;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.ProductDTO;

@FeignClient(name = "product-service" ,url = "http://localhost:8085")
public interface ProductClient {
 
    @GetMapping("/api/products/{productId}")
    ProductDTO getProductById(@PathVariable("productId") Long productId);
 
    @GetMapping("/api/products/vendor/{vendorId}")
    List<ProductDTO> getProductsByVendor(@PathVariable("vendorId") Long vendorId);
 
    @GetMapping("/api/products")
    List<ProductDTO> getAllProducts();
}