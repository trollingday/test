package spring.mvc.kyj.dto;

import java.sql.Date;

public class OrderDTO {
	
	private int orderNo;
	private String pdName;
	private String brand;
	private int pdsize;
	private int totalPrice;
	private int quantity;
	private String orderStatus;
	private String cusName;
	private Date orderDate;
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
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
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return "OrderDTO [orderNo=" + orderNo + ", pdName=" + pdName + ", brand=" + brand + ", pdsize=" + pdsize
				+ ", totalPrice=" + totalPrice + ", quantity=" + quantity + ", orderStatus=" + orderStatus
				+ ", cusName=" + cusName + ", orderDate=" + orderDate + "]";
	}
	
}
