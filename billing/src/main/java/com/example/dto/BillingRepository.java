package com.example.dto;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.example.entity.Billing;
 
@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
    List<Billing> findByCustomerId(Long customerId);
}