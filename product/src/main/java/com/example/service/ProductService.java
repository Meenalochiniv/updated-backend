package com.example.service;

import java.math.BigDecimal;

//import java.util.List;
// 
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Service;
// 
//import com.example.dto.ProductRepository;
//
//import com.example.dto.VendorDTO;
//
//import com.example.entity.Product;
//
//import com.example.feignclients.VendorClient;
// 
//@Service
//
//public class ProductService {
//
//    private final ProductRepository productRepository = null;
//
//    private final VendorClient vendorClient = null;
//
//    // Add a new product
//
//    public Product addProduct(Long vendorId, Product product) {
//
//        VendorDTO vendor = vendorClient.getVendorById(vendorId);
//
//        if (vendor != null) {
//
//            product.setVendorId(vendorId);
//
//            return productRepository.save(product);
//
//        }
//
//        return null; // Vendor not found
//
//    }
//
//    // Update a product
//
//    public Product updateProduct(Long productId, Product productDetails) {
//
//        Product product = productRepository.findById(productId).orElse(null);
//
//        if (product != null) {
//
//            product.setProductMaterial(productDetails.getProductMaterial());
//
//            product.setProductWeight(productDetails.getProductWeight());
//
//            product.setProductGmPerWeight(productDetails.getProductGmPerWeight());
//
//            product.setProductQuantity(productDetails.getProductQuantity());
//
//            return productRepository.save(product);
//
//        }
//
//        return null; // Product not found
//
//    }
//
//    // Delete a product
//
//    public void deleteProduct(Long productId) {
//
//        if (productRepository.existsById(productId)) {
//
//            productRepository.deleteById(productId);
//
//        }
//
//    }
//
//    // Get all products for a vendor
//
//    public List<Product> getProductsByVendor(Long vendorId) {
//
//        return productRepository.findByVendorId(vendorId);
//
//    }
//
//}
//
// 


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProductRepository;
import com.example.dto.VendorDTO;
import com.example.entity.Product;
import com.example.feignclients.VendorClient;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final VendorClient vendorClient;

    @Autowired
    public ProductService(ProductRepository productRepository, VendorClient vendorClient) {
        this.productRepository = productRepository;
        this.vendorClient = vendorClient;
    }

   
    public Product addProduct(Long vendorId, Product product) {

if (product.getProducttotalcost() == null) {
        product.setProducttotalcost(BigDecimal.ZERO); // or any default value
    
}
        VendorDTO vendor = vendorClient.getVendorById(vendorId);
        if (vendor != null) {
            product.setVendorId(vendorId);
            return productRepository.save(product);
        }
        return null; 
    }

    
    public Product updateProduct(Long productId, Product productDetails) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            product.setProductMaterial(productDetails.getProductMaterial());
            product.setProductWeight(productDetails.getProductWeight());
            product.setProducttotalcost(productDetails.getProducttotalcost());
            product.setProductQuantity(productDetails.getProductQuantity());
            return productRepository.save(product);
        }
        return null; 
    }

   
    public void deleteProduct(Long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
        }
    }

   
    public List<Product> getProductsByVendor(Long vendorId) {
        return productRepository.findByVendorId(vendorId);
    }
    
   
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
