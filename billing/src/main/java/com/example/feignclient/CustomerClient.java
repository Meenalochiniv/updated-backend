package com.example.feignclient;



import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
 
import com.example.dto.CustomerDTO;
 
@FeignClient(name = "customer-service",url = "http://localhost:8086")

public interface CustomerClient {

    @GetMapping("/api/customers/{customerId}")

    CustomerDTO getCustomerById(@PathVariable("customerId") Long customerId);

}
 