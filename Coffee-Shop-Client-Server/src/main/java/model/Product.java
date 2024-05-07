package model;

public class Product {
	private int ID;
	private String NameProduct;
	private int QuantityProduct;
	private boolean Category;
	private float Price;
	public Product() {
		super();
	}
	public Product(int iD, String nameProduct, int quantityProduct, boolean category, float price) {
		super();
		ID = iD;
		NameProduct = nameProduct;
		QuantityProduct = quantityProduct;
		Category = category;
		Price = price;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNameProduct() {
		return NameProduct;
	}
	public void setNameProduct(String nameProduct) {
		NameProduct = nameProduct;
	}
	public int getQuantityProduct() {
		return QuantityProduct;
	}
	public void setQuantityProduct(int quantityProduct) {
		QuantityProduct = quantityProduct;
	}
	public boolean isCategory() {
		return Category;
	}
	public void setCategory(boolean category) {
		Category = category;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "Product [ID=" + ID + ", NameProduct=" + NameProduct + ", QuantityProduct=" + QuantityProduct
				+ ", Category=" + Category + ", Price=" + Price + "]";
	}
	
	
}
