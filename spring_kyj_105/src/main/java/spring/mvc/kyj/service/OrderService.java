package spring.mvc.kyj.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import spring.mvc.kyj.dto.CustomerDTO;
import spring.mvc.kyj.dto.OrderDTO;

public interface OrderService {
	
	//결제 상세페이지
	public CustomerDTO purchasingDetail(String strId);
	
	public int orderInsert(OrderDTO dto);
	
	//관리자 주문목록
	public void orderList(HttpServletRequest req, Model model);
	
	//결제 승인
	public void payPermit(HttpServletRequest req, Model model);

	//결제 취소
	public void payCancel(HttpServletRequest req, Model model);
	
	//고객 주문목록
	public void cusOrderList(HttpServletRequest req, Model model);
	
	//구매 취소
	public void purchasedCancel(HttpServletRequest req, Model model);
	
	//환불 요청
	public void refundReq(HttpServletRequest req, Model model);
	
	//환불 요청 목록
	public void refundList(HttpServletRequest req, Model model);
	
	//환불 요청 승인
	public void refundPermit(HttpServletRequest req, Model model);
	
	//환불 요청 거절
	public void refundReject(HttpServletRequest req, Model model);
	
	//결산내역
	public void saleHistory(HttpServletRequest req, Model model);
	
	//결산차트
	public void saleChart(HttpServletRequest req, Model model);
	
	//장바구니 목록
	public void cartList(HttpServletRequest req, Model model);
	
	//장바구니에 담기
	public void cartAdd(HttpServletRequest req, Model model);
	
	//장바구니에 빼기
	public void cartRemove(HttpServletRequest req, Model model);
	
	//장바구니 담은 물건 결제
	public void cartPay(HttpServletRequest req, Model model);
}
