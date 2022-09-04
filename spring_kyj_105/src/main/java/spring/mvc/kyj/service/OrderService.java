package spring.mvc.kyj.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import spring.mvc.kyj.dto.CartDTO;
import spring.mvc.kyj.dto.OrderDTO;

public interface OrderService {
		
	public void orderInsert(OrderDTO dto, Model model);
	
	public void orderList(String pageNum ,Model model);
	
	public void payPermit(int orderNo, String orderState, Model model);

	public void payCancel(int orderNo, String orderState, Model model);
	
	public void cusOrderList(String strId, Model model);
	
	public void purchasedCancel(int orderNo, String orderState, Model model);
	
	public void refundReq(int orderNo, String orderState, Model model);
	
	public void refundList(String pageNum,Model model);
	
	public void refundPermit(int orderNo, String orderState, Model model);
	
	public void refundReject(int orderNo, String orderState, Model model);
	
	public void saleHistory(String pageNum, Model model);
	
	public void saleChart(Model model);
	
	public void cartAdd(HttpServletRequest req, CartDTO dto,Model model);

	public void cartRemove(HttpServletRequest req, Model model);
	
	public void cartPay(HttpServletRequest req, Model model);
}
