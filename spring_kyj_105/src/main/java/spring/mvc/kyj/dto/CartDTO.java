package spring.mvc.kyj.dto;

public class CartDTO {

	private String pdName;
	private String brand;
	private int pdsize;
	private int price;
	private int quantity;
	
	public String getPdName() {
		return pdName;
	}
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPdsize() {
		return pdsize;
	}
	public void setPdsize(int pdsize) {
		this.pdsize = pdsize;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
