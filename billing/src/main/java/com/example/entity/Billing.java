package com.example.entity;



import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.Table;
 
@Entity

@Table(name = "Billing")

public class Billing {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long billNo;

    private double totalCost;

    private Long customerId;

	public Long getBillNo() {

		return billNo;

	}

	public void setBillNo(Long billNo) {

		this.billNo = billNo;

	}

	public double getTotalCost() {

		return totalCost;

	}

	public void setTotalCost(double totalCost) {

		this.totalCost = totalCost;

	}

	public Long getCustomerId() {

		return customerId;

	}

	public void setCustomerId(Long customerId) {

		this.customerId = customerId;

	}

    // Getters and Setters

}
 