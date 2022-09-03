package spring.mvc.kyj.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.kyj.dto.OrderDTO;
import spring.mvc.kyj.service.OrderServiceImpl;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderServiceImpl service;

	//------------- 즉시구매 ---------------
	
	//주문정보 입력한다.
	@RequestMapping("purchasingAction.od")
	public String purchasingAction(OrderDTO dto, Model model) {
		logger.info("[url => purchasingAction.od]");
		
		service.orderInsert(dto, model); 
		
		return "product/purchasingAction";
	}

	//-------------- 결제관리 ---------------
	
    //관리자 주문목록을 보여준다.
	@RequestMapping("orderList.od")
	public String orderList(String pageNum ,Model model) {
		logger.info("[url => orderList.od]");
			
		service.orderList(pageNum ,model);
		
		return "manager/order/orderList";
	}	
	
	//결제 승인을 한다.
	@RequestMapping("payPermit.od")
	public String payPermit(int orderNo, String orderState, Model model) {
		logger.info("[url => payPermit.od]");
		
		service.payPermit(orderNo, orderState, model);
		
		return "manager/order/adminOrderAction";
	}

	
	//결제취소를 한다.(재고가 없으면)
	@RequestMapping("payCancel.od")
	public String payCancel(int orderNo, String orderState, Model model) {
		logger.info("[url => payCancel.od]");
		
		service.payCancel(orderNo, orderState, model);
		
		return "manager/order/adminOrderAction";
	}
	
	//------------------고객 주문 ---------------------
	
	//고객 주문목록 보여준다.
	@RequestMapping("customerOrderList.od")
	public String customerOrderList(HttpServletRequest req, Model model) {
		logger.info("[url => customerOrderList.od]");
		
		String strId = (String)req.getSession().getAttribute("customerID");
        service.cusOrderList(strId, model);
        
		return "customer/mypage/customerInfo/customerOrderList";
	}
	
	//구매취소를 한다. (결제승인 되기전에만 가능)
	@RequestMapping("purchasedCancel.od")
	public String purchasedCancel(int orderNo, String orderState, Model model) {
		logger.info("[url => purchasedCancel.od]");
		
		service.purchasedCancel(orderNo, orderState, model);
		
		return "customer/mypage/customerInfo/customerOrderAction";
	}
	
	//환불요청을 한다. (결제승인 후에 가능)
	@RequestMapping("/refundReq.od")
	public String refundReq(int orderNo, String orderState, Model model) {
		logger.info("[url => /refundReq.od]");
		
		service.refundReq(orderNo, orderState, model);
		
		return "customer/mypage/customerInfo/customerOrderAction";
	}
		
	//----------------환불 관리-----------------
	
	//환불 요청 목록을 보여준다.
	@RequestMapping("/refundList.od")
	public String refundList(String pageNum,Model model) {
		logger.info("[url => /refundList.od]");
		
		service.refundList(pageNum, model);
		
		return "manager/order/refundList";
	}
	
	//환불요청 승인을 한다.
	@RequestMapping("/refundPermit.od")
	public String refundPermit(int orderNo, String orderState, Model model) {
		logger.info("[url => /refundPermit.od]");
		
		service.refundPermit(orderNo, orderState, model);
		
		return "manager/order/refundAction";
	}
	 
	//환불요청 거절을 한다.
	@RequestMapping("/refundReject.od")
	public String refundReject(int orderNo, String orderState, Model model) {
		logger.info("[url => /refundReject.od]");
		
		service.refundReject(orderNo, orderState, model);
		
		return "manager/order/refundAction";
	}
		
	//--------------결산--------------
	
	//결산내역을 보여준다.
	@RequestMapping("/saleHistory.od")
	public String saleHistory(String pageNum, Model model) {
		logger.info("[url => /saleHistory.od]");
		
		service.saleHistory(pageNum, model);
		
		return "manager/order/saleHistory";
	}
	
	//결산 차트를 보여준다.
	@RequestMapping("/saleChart.od")
	public String saleChart(Model model) {
		logger.info("[url => /saleChart.od]");
		
		service.saleChart(model);
		
		return "manager/order/saleChart";
	}
	
	//------------------장바구니----------------------
	
	@RequestMapping("/cartAdd.od")
	public String cartAdd(HttpServletRequest req,Model model) {
		logger.info("[url => /cartAdd.od]");
		
		service.cartAdd(req, model);
		return "customer/cart/cartList";
	}
	
	@RequestMapping("/cartList.od")
	public String cartList(HttpServletRequest req,Model model) {
		logger.info("[url => /cartList.od]");
		
		service.cartList(req, model);
		return "customer/cart/cartList";
	}
	
	@RequestMapping("/cartRemove.od")
	public String cartRemove(HttpServletRequest req,Model model) {
		logger.info("[url => /cartRemove.od]");
		
		service.cartRemove(req, model);
		return "customer/cart/cartList";
	}
	
	@RequestMapping("/cartPay.od")
	public String cartPay(HttpServletRequest req,Model model) {
		logger.info("[url => /cartPay.od]");
		
		service.cartPay(req,model);
		return "product/purchasingAction";
	}
}
