package com.example.service;



import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
 
import com.example.dto.BillingRepository;

import com.example.dto.CustomerDTO;

import com.example.dto.ProductDTO;

import com.example.entity.Billing;

import com.example.feignclient.CustomerClient;

import com.example.feignclient.ProductClient;
 
@Service

public class BillingService {

    @Autowired

    private BillingRepository billingRepository;

    @Autowired

    private CustomerClient customerClient;

    @Autowired

    private ProductClient productClient;

    // Generate a new bill

    public Billing generateBill(Long customerId, List<Long> productIds) {

        // Fetch customer details using Feign Client

        CustomerDTO customer = customerClient.getCustomerById(customerId);

        if (customer == null) {

            throw new RuntimeException("Customer not found");

        }

        // Calculate total cost by fetching product details

        double totalCost = 0.0;

        for (Long productId : productIds) {

            ProductDTO product = productClient.getProductById(productId);

            if (product != null) {

                totalCost += product.getProductGmPerWeight() * product.getProductWeight();

            }

        }

        // Create a new bill

        Billing bill = new Billing();

        bill.setCustomerId(customerId);

        bill.setTotalCost(totalCost);

        return billingRepository.save(bill);

    }

    // Get bill by customer ID

    public List<Billing> getBillsByCustomerId(Long customerId) {

        return billingRepository.findByCustomerId(customerId);

    }

    // Get bill by bill number

    public Billing getBillByBillNo(Long billNo) {

        return billingRepository.findById(billNo).orElse(null);

    }

}
 