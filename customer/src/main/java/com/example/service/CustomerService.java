package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CustomerRepository;
import com.example.dto.ProductDTO;
import com.example.entity.Customer;
import com.example.feignclient.ProductClient;

@Service
public class CustomerService {
 
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private ProductClient productClient; 
 
    
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
 
  
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }
 
  
    public Customer updateCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getCustomerId())) {
            return customerRepository.save(customer);
        }
        return null; 
    }
 
    
    public void deleteCustomer(Long customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
        }
    }
 
   
    public ProductDTO viewProductById(Long productId) {
        return productClient.getProductById(productId);
    }
 
    
    public List<ProductDTO> viewAllProducts() {
        return productClient.getAllProducts();
    }
 
    
    public List<ProductDTO> viewProductsByVendor(Long vendorId) {
        return productClient.getProductsByVendor(vendorId);
    }
}
