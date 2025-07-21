package com.example.entity;



import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
 
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productMaterial;

    private double productWeight;
    
    @Column(name = "total_cost") 
    private BigDecimal totalcost;

    private int productQuantity;

    private Long vendorId;  
    
    private String imageUrl;
 
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getProductId() {

		return productId;

	}
 
	public void setProductId(Long productId) {

		this.productId = productId;

	}
 
	public String getProductMaterial() {

		return productMaterial;

	}
 
	public void setProductMaterial(String productMaterial) {

		this.productMaterial = productMaterial;

	}
 
	public double getProductWeight() {

		return productWeight;

	}
 
	public void setProductWeight(double productWeight) {

		this.productWeight = productWeight;

	}
 
	public BigDecimal getProducttotalcost() {

		return totalcost;

	}
 
	public void setProducttotalcost(BigDecimal totalcost) {

		this.totalcost = totalcost;

	}
 
	public int getProductQuantity() {

		return productQuantity;

	}
 
	public void setProductQuantity(int productQuantity) {

		this.productQuantity = productQuantity;

	}
 
	public Long getVendorId() {

		return vendorId;

	}
 
	public void setVendorId(Long vendorId) {

		this.vendorId = vendorId;

	}

    
}
 