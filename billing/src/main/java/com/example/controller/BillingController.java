package com.example.controller;


import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
 
import com.example.entity.Billing;

import com.example.service.BillingService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping("/billing")

public class BillingController {

    @Autowired

    private BillingService billingService;

    // Generate a new bill

    @PostMapping("/generate")

    public ResponseEntity<Billing> generateBill(

            @RequestParam Long customerId,

            @RequestParam List<Long> productIds) {

        Billing bill = billingService.generateBill(customerId, productIds);

        return ResponseEntity.ok(bill);

    }

    // Get all bills for a customer

    @GetMapping("/customer/{customerId}")

    public ResponseEntity<List<Billing>> getBillsByCustomerId(@PathVariable Long customerId) {

        List<Billing> bills = billingService.getBillsByCustomerId(customerId);

        return ResponseEntity.ok(bills);

    }

    // Get bill by bill number

    @GetMapping("/{billNo}")

    public ResponseEntity<Billing> getBillByBillNo(@PathVariable Long billNo) {

        Billing bill = billingService.getBillByBillNo(billNo);

        if (bill != null) {

            return ResponseEntity.ok(bill);

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }

}
 