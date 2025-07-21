package com.example.dto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}