package spring.mvc.kyj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.kyj.common.Pagination;
import spring.mvc.kyj.dao.OrderDAO;
import spring.mvc.kyj.dto.CartDTO;
import spring.mvc.kyj.dto.CustomerDTO;
import spring.mvc.kyj.dto.OrderDTO;
import spring.mvc.kyj.service.OrderServiceImpl;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderServiceImpl service;
	
	@Autowired
	OrderDAO dao;
	
	//------------- 즉시구매 ---------------
	
	//주문정보 입력한다.
	@RequestMapping("purchasingAction.od")
	public String purchasingAction(OrderDTO dto, Model model) {
		logger.info("[url => purchasingAction.od]");
		
		String orderStatus="구매요청";
		dto.setOrderStatus(orderStatus);
        int insertCnt = service.orderInsert(dto);      
        model.addAttribute("insertCnt", insertCnt);	
        
		return "product/purchasingAction";
	}

	//-------------- 결제관리 ---------------
	
    //관리자 주문목록을 보여준다.
	@RequestMapping("orderList.od")
	public String orderList(String pageNum ,Model model) {
		logger.info("[url => orderList.od]");
			
		Pagination paging = new Pagination(pageNum);
		int total=dao.orderCnt();
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
							
		List<OrderDTO> OrderBox = service.orderList(map);
        
		model.addAttribute("OrderBox", OrderBox);
		model.addAttribute("paging",paging);
		
		return "manager/order/orderList";
	}	
	
	@RequestMapping("payPermit.od")
	public String payPermit(HttpServletRequest req,Model model) {
		logger.info("[url => payPermit.od]");
		
		service.payPermit(req, model);
		return "manager/order/adminOrderAction";
	}

	@RequestMapping("payCancel.od")
	public String payCancel(HttpServletRequest req,Model model) {
		logger.info("[url => payCancel.od]");
		
		service.payCancel(req, model);
		return "manager/order/adminOrderAction";
	}
	
	//------------------고객 주문 ---------------------
	
	@RequestMapping("customerOrderList.od")
	public String customerOrderList(HttpServletRequest req,Model model) {
		logger.info("[url => customerOrderList.od]");
		
        service.cusOrderList(req, model);
		return "customer/mypage/customerInfo/customerOrderList";
	}
	
	@RequestMapping("purchasedCancel.od")
	public String purchasedCancel(HttpServletRequest req,Model model) {
		logger.info("[url => purchasedCancel.od]");
		
		service.purchasedCancel(req, model);
		return "customer/mypage/customerInfo/customerOrderAction";
	}
	
	@RequestMapping("/refundReq.od")
	public String refundReq(HttpServletRequest req,Model model) {
		logger.info("[url => /refundReq.od]");
		
		service.refundReq(req, model);
		return "customer/mypage/customerInfo/customerOrderAction";
	}
		
	//----------------환불 관리-----------------
	
	@RequestMapping("/refundList.od")
	public String refundList(HttpServletRequest req,Model model) {
		logger.info("[url => /refundList.od]");
		
		service.refundList(req, model);
		return "manager/order/refundList";
	}
	
	@RequestMapping("/refundPermit.od")
	public String refundPermit(HttpServletRequest req,Model model) {
		logger.info("[url => /refundPermit.od]");
		
		service.refundPermit(req, model);
		return "manager/order/refundAction";
	}
	 
	@RequestMapping("/refundReject.od")
	public String refundReject(HttpServletRequest req,Model model) {
		logger.info("[url => /refundReject.od]");
		
		service.refundReject(req, model);
		return "manager/order/refundAction";
	}
		
	//--------------결산--------------
	
	@RequestMapping("/saleHistory.od")
	public String saleHistory(HttpServletRequest req,Model model) {
		logger.info("[url => /saleHistory.od]");
		
		service.saleHistory(req, model);
		return "manager/order/saleHistory";
	}
	
	@RequestMapping("/saleChart.od")
	public String saleChart(HttpServletRequest req,Model model) {
		logger.info("[url => /saleChart.od]");
		
		service.saleChart(req, model);
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
