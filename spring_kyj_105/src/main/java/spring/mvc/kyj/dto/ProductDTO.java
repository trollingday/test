package spring.mvc.kyj.dto;

import java.sql.Date;

/*
CREATE TABLE mvc_product_tbl(
	    pdNo NUMBER PRIMARY KEY,
	    pdName VARCHAR2(50) NOT NULL UNIQUE,
	    pdImg VARCHAR2(100) NOT NULL,
	    brand VARCHAR2(20) NOT NULL,
	    pdsize NUMBER NOT NULL,
	    price NUMBER NOT NULL,
	    quantity NUMBER DEFAULT 0,
	    status VARCHAR2(20) NOT NULL,
	    indate DATE DEFAULT sysdate
	);
*/

public class ProductDTO {
	
	private int pdNo;
	private String pdName;
	private String pdImg;
	private String brand;
	private int pdsize;
	private int price;
	private int quantity;
	private String status;
	private Date indate;
	
	public ProductDTO() { }
	
	public int getPdNo() {
		return pdNo;
	}
	public void setPdNo(int pdNo) {
		this.pdNo = pdNo;
	}
	public String getPdName() {
		return pdName;
	}
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	public String getPdImg() {
		return pdImg;
	}
	public void setPdImg(String pdImg) {
		this.pdImg = pdImg;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	
	@Override
	public String toString() {
		return "productDTO [pdNo=" + pdNo + ", pdName=" + pdName + ", pdImg=" + pdImg + ", brand=" + brand + ", pdsize=" + pdsize + ", price=" + price + ", quantity=" + quantity
				+ ", status=" + status + ", indate=" + indate + "]";
	}
	
}
