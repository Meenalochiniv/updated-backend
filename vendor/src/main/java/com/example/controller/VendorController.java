package com.example.controller;


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

import com.example.entity.Vendor;
import com.example.service.VendorService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/vendors")
public class VendorController {
 
    @Autowired
    private VendorService vendorService;
 
    // Add a new vendor
    @PostMapping("/post")
    public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {
        Vendor newVendor = vendorService.addVendor(vendor);
        return ResponseEntity.ok(newVendor);
    }
 
    // Get a vendor by ID
    @GetMapping("/{vendorId}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long vendorId) {
        Vendor vendor = vendorService.getVendorById(vendorId);
        if (vendor != null) {
            return ResponseEntity.ok(vendor);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
 
    // Update a vendor
//    @PutMapping("/put")
//    public ResponseEntity<Vendor> updateVendor(@RequestBody Vendor vendor) {
//        Vendor updatedVendor = vendorService.updateVendor(vendor);
//        if (updatedVendor != null) {
//            return ResponseEntity.ok(updatedVendor);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // vendor not found
//    }
    @PutMapping("/{vendorId}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long vendorId, @RequestBody Vendor vendor) {
        vendor.setVendorId(vendorId); // Ensure the ID is set
        Vendor updatedVendor = vendorService.updateVendor(vendor);
        if (updatedVendor != null) {
            return ResponseEntity.ok(updatedVendor);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Delete a vendor
    @DeleteMapping("/{vendorId}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long vendorId) {
        vendorService.deleteVendor(vendorId);
        return ResponseEntity.ok("Vendor deleted successfully!");
    }
}
