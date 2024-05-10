package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


public class ProductModel {
	private Integer ProductID;
	private String ProductName;
	private boolean ProductCategory;
	private float ProductPrice;
	private boolean ProductStatus;
	
	public ProductModel() {
		
	}

	public ProductModel(Integer productID, String productName, boolean productCategory, float productPrice,
			boolean productStatus) {
		
		ProductID = productID;
		ProductName = productName;
		ProductCategory = productCategory;
		ProductPrice = productPrice;
		ProductStatus = productStatus;
	}

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public boolean isProductCategory() {
		return ProductCategory;
	}

	public void setProductCategory(boolean productCategory) {
		ProductCategory = productCategory;
	}

	public float getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(float productPrice) {
		ProductPrice = productPrice;
	}

	public boolean isProductStatus() {
		return ProductStatus;
	}

	public void setProductStatus(boolean productStatus) {
		ProductStatus = productStatus;
	}
	
	
	

	

}
