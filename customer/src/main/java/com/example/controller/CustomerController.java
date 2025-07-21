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

import com.example.dto.ProductDTO;
import com.example.entity.Customer;
import com.example.service.CustomerService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
 
    @Autowired
    private CustomerService customerService;
 
    
    @PostMapping("/post")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return ResponseEntity.ok(newCustomer);
    }
 
    
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return customer != null 
            ? ResponseEntity.ok(customer) 
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
 
   
    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        customer.setCustomerId(customerId);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return updatedCustomer != null 
            ? ResponseEntity.ok(updatedCustomer) 
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
 
    
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok().build();
    }
 
   
    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductDTO> viewProductById(@PathVariable Long productId) {
        ProductDTO product = customerService.viewProductById(productId);
        return ResponseEntity.ok(product);
    }
 
    
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> viewAllProducts() {
        List<ProductDTO> products = customerService.viewAllProducts();
        return ResponseEntity.ok(products);
    }
 
    
    @GetMapping("/products/vendor/{vendorId}")
    public ResponseEntity<List<ProductDTO>> viewProductsByVendor(@PathVariable Long vendorId) {
        List<ProductDTO> products = customerService.viewProductsByVendor(vendorId);
        return ResponseEntity.ok(products);
    }
}
