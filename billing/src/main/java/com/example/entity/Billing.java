package com.example.entity;



import java.math.BigDecimal;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.Table;
 
//@Entity
//
//@Table(name = "Billing")

//public class Billing {
//
//    @Id
//
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    private Long billNo;
//
//    private double totalCost;
//
//    private Long customerId;
//
//	public Long getBillNo() {
//
//		return billNo;
//
//	}
//
//	public void setBillNo(Long billNo) {
//
//		this.billNo = billNo;
//
//	}
//
//	public double getTotalCost() {
//
//		return totalCost;
//
//	}
//
//	public void setTotalCost(double totalCost) {
//
//		this.totalCost = totalCost;
//
//	}
//
//	public Long getCustomerId() {
//
//		return customerId;
//
//	}
//
//	public void setCustomerId(Long customerId) {
//
//		this.customerId = customerId;
//
//	}
//
//    // Getters and Setters
//
//}
 

@Entity
@Table(name = "Billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billNo;

    public Long getBillNo() {
		return billNo;
	}
	public void setBillNo(Long billNo) {
		this.billNo = billNo;
	}
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(BigDecimal totalCost2) {
		this.totalCost = totalCost2;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	private BigDecimal totalCost;
    private Long customerId;
    private String shippingAddress;
    private String paymentMethod;

    
}
