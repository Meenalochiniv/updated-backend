package com.example.dto;



public class ProductDTO {
    private Long productId;
    private String productMaterial;
    private double productWeight;
    private double productGmPerWeight;
    private int productQuantity;
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
	public double getProductGmPerWeight() {
		return productGmPerWeight;
	}
	public void setProductGmPerWeight(double productGmPerWeight) {
		this.productGmPerWeight = productGmPerWeight;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
 
    // Getters and Setters
    
}
 