package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.VendorRepository;
import com.example.entity.Vendor;

@Service
public class VendorService {
 
    @Autowired
    private VendorRepository vendorRepository;
 
    // Add a new vendor
    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }
 
    // Get a vendor by ID
    public Vendor getVendorById(Long vendorId) {
        return vendorRepository.findById(vendorId).orElse(null);
    }
 
    // Update a vendor
    public Vendor updateVendor(Vendor vendor) {
        if (vendorRepository.existsById(vendor.getVendorId())) {
            return vendorRepository.save(vendor);
        }
        return null; // vendor not found
    }
 
    // Delete a vendor
    public void deleteVendor(Long vendorId) {
        if (vendorRepository.existsById(vendorId)) {
            vendorRepository.deleteById(vendorId);
        }
    }
}
