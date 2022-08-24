package spring.mvc.kyj.dto;

public class ChartDTO {
	
	private String month;
	private int totalPrice;
	
	public ChartDTO() { }

	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ChartDTO [month=" + month + ", totalPrice=" + totalPrice + "]";
	}
	
}
