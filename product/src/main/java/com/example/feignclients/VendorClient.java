package com.example.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.VendorDTO;
import com.example.entity.Vendor;
 
@FeignClient(name = "vendor-service",url = "http://localhost:8084/api/vendors")
public interface VendorClient {
    @GetMapping("/{vendorId}")
    VendorDTO getVendorById(@PathVariable("vendorId") Long vendorId);

    @PostMapping("/post")
    public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor);
}