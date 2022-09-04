package spring.mvc.kyj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.kyj.dto.OrderDTO;
import spring.mvc.kyj.dto.CartDTO;
import spring.mvc.kyj.dto.ChartDTO;
import spring.mvc.kyj.dto.CustomerDTO;
import spring.mvc.kyj.common.Pagination;
import spring.mvc.kyj.dao.CustomerDAO;
import spring.mvc.kyj.dao.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO dao;
	
	@Autowired	
	CustomerDAO dao2;
	
	@Override
	public void orderInsert(OrderDTO dto, Model model) {		
		String orderStatus="구매요청";
		dto.setOrderStatus(orderStatus);
        int insertCnt = dao.InsertOrder(dto);     
        model.addAttribute("insertCnt", insertCnt);				
	}

	@Override
	public void orderList(String pageNum ,Model model) {		
		Pagination paging = new Pagination(pageNum);
		int total=dao.orderCnt();
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
							
		List<OrderDTO> OrderBox = dao.orderList(map);
        
		model.addAttribute("OrderBox", OrderBox);
		model.addAttribute("paging",paging);		
	}
	
	@Override
	public void payPermit(int orderNo, String orderState, Model model) {		
		int payResult = -99;
		
		if(orderState.equals("구매요청")) {
					
			//1.주문정보에서 상품이름,상품사이즈,상품수량 정보 추출
			OrderDTO dto = dao.selectOrder(orderNo);
			
			//2.추출한 상품정보를 가지고 재고테이블에서 재고업데이트
			int updateCnt = dao.stockUpdate(dto);		
			
			if(updateCnt!=0) {
							
				//3.주문정보에서 주문상태 변경("결제승인")
				String state="결제승인";
				
				Map<String, Object> map=new HashMap<String, Object>();
				
				map.put("orderNo", orderNo);
				map.put("state", state);
				
				dao.orderUpdate(map);	
				payResult = 1;
			} else {
				payResult = -1;
			}
		}		
		
		model.addAttribute("payResult",payResult);
	}

	@Override
	public void payCancel(int orderNo, String orderState, Model model) {
		int payResult=-99;
		
		if(orderState.equals("구매요청")) {
											
			String state="결제취소";
			
			Map<String, Object> map=new HashMap<String, Object>();
			
			map.put("orderNo", orderNo);
			map.put("state", state);
			
			dao.orderUpdate(map);	
			payResult=0;		
		}		
		
		model.addAttribute("payResult",payResult);
	}

	@Override
	public void cusOrderList(String strId, Model model) {		
		CustomerDTO dto = dao2.getCustomerDetail(strId);
		
		List<OrderDTO> OrderBox = dao.cusOrderList(dto.getName());
			
		model.addAttribute("OrderBox", OrderBox);			
	}
	
	@Override
	public void purchasedCancel(int orderNo, String orderState, Model model) {
		
		int buyResult=-99;
				
		if(orderState.equals("구매요청")) {
	
			//2.주문테이블에서 주문상태 변경
			String state="구매취소";
			
			Map<String, Object> map=new HashMap<String, Object>();
			
			map.put("orderNo", orderNo);
			map.put("state", state);
			
			int updateCnt = dao.orderUpdate(map);	
			System.out.println("purchasedCancel - updateCnt : "+updateCnt);
			buyResult=1;
		}		
		
		model.addAttribute("buyResult",buyResult);
	}

	@Override
	public void refundReq(int orderNo, String orderState, Model model) {
		
		int buyResult=-99;
		
		if(orderState.equals("결제승인")) {
			
			//2.주문테이블에서 주문상태 변경
			String state="환불요청";
			
			Map<String, Object> map=new HashMap<String, Object>();
			
			map.put("orderNo", orderNo);
			map.put("state", state);
			
			int updateCnt = dao.orderUpdate(map);	
			System.out.println("refundReq - updateCnt : "+updateCnt);
			
			buyResult=0;
		}		
		
		model.addAttribute("buyResult",buyResult);
	}

	@Override
	public void refundList(String pageNum, Model model) {
			
		Pagination paging = new Pagination(pageNum);
		
		int total=dao.refundCnt();
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("start", start);
		map.put("end", end);
		
		List<OrderDTO> refundBox = dao.refundList(map);
			
		model.addAttribute("refundBox", refundBox);
		model.addAttribute("paging",paging);
		
	}

	@Override
	public void refundPermit(int orderNo, String orderState, Model model) {

		int refundResult = -99;

		if(orderState.equals("환불요청")) {
	
			//1.주문정보에서 상품이름,상품사이즈,상품수량 정보 추출
			OrderDTO dto = dao.selectOrder(orderNo);
			
			//2.추출한 상품정보를 가지고 재고테이블에서 재고업데이트
			int updateCnt = dao.stockUpdate2(dto);		
			System.out.println("refundPermit - updateCnt : "+updateCnt);
			
			//3.주문정보에서 주문상태 변경("환불승인")
			String state="환불승인";
			
			Map<String, Object> map=new HashMap<String, Object>();
			
			map.put("orderNo", orderNo);
			map.put("state", state);
			
			int updateCnt2 = dao.orderUpdate(map);	
			System.out.println("refundPermit - updateCnt2 : "+updateCnt2);
			
			refundResult = 1;
		}
		
		model.addAttribute("refundResult",refundResult);
	}
	
	@Override
	public void refundReject(int orderNo, String orderState, Model model) {

		int refundResult = -99;
		
		if(orderState.equals("환불요청")) {
			
			//2.주문테이블에서 주문상태 변경
			String state="환불거절";
			
			Map<String, Object> map=new HashMap<String, Object>();
			
			map.put("orderNo", orderNo);
			map.put("state", state);
			
			int updateCnt = dao.orderUpdate(map);	
			System.out.println("refundReject - updateCnt : "+updateCnt);
			
			refundResult = 0;
		}
		
		model.addAttribute("refundResult",refundResult);
	}

	@Override
	public void saleHistory(String pageNum, Model model) {
		
		Pagination paging = new Pagination(pageNum);
		
		int total=dao.payPermitCnt();
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("start", start);
		map.put("end", end);
		
		List<OrderDTO> saleHistoryBox = dao.saleHistoryList(map);

		model.addAttribute("saleHistoryBox", saleHistoryBox);
		model.addAttribute("paging",paging);	
		
	}
	
	@Override
	public void saleChart(Model model) {

		int[] totalPrice = new int[12];
		int cnt=0;
		
		for(int j=0;j<12;j++) {
			totalPrice[j]=0;
		}
		
		List<ChartDTO> chartBox = dao.saleChart();
		
		for(int i=0;i<12;i++) {
				
			if(cnt<chartBox.size()) {
				
				int month=Integer.parseInt(chartBox.get(i).getMonth());
				cnt=cnt+1;
				
				switch(month) {
				    case 1:
				    	totalPrice[0] = chartBox.get(i).getTotalPrice();				    	
			        break;				
				    case 2:
				    	totalPrice[1] = chartBox.get(i).getTotalPrice();				    	
			        break;					
				    case 3:
				    	totalPrice[2] = chartBox.get(i).getTotalPrice();				    	
			        break;					
				    case 4:
				    	totalPrice[3] = chartBox.get(i).getTotalPrice();				    	
			        break;					
				    case 5:
				    	totalPrice[4] = chartBox.get(i).getTotalPrice();				    	
			        break;					
				    case 6:
				    	totalPrice[5] = chartBox.get(i).getTotalPrice();				    	
			        break;	
				    case 7:
				    	totalPrice[6] = chartBox.get(i).getTotalPrice();				    	
			        break;				
				    case 8:
				    	totalPrice[7] = chartBox.get(i).getTotalPrice();				    	
			        break;					
				    case 9:
				    	totalPrice[8] = chartBox.get(i).getTotalPrice();				    	
			        break;					
				    case 10:
				    	totalPrice[9] = chartBox.get(i).getTotalPrice();				    	
			        break;					
				    case 11:
				    	totalPrice[10] = chartBox.get(i).getTotalPrice();				    	
			        break;					
				    case 12:
				    	totalPrice[11] = chartBox.get(i).getTotalPrice();				    	
			        break;			        
			        	
				}
						
			} else {
				break;
			}
		}
		
		model.addAttribute("totalPrice", totalPrice);
	}

	@Override
	public void cartAdd(HttpServletRequest req, CartDTO dto,Model model) {	
		List<CartDTO> cartbox = (List<CartDTO>) req.getSession().getAttribute("cartbox");
		cartbox.add(dto);
		req.getSession().setAttribute("cartbox",cartbox);			
	}
	
	@Override
	public void cartRemove(HttpServletRequest req, Model model) {

		String[] cartIds=req.getParameter("cartId").split(",");
		
		List<CartDTO> cartbox = (List<CartDTO>) req.getSession().getAttribute("cartbox");
		int[] index=new int[cartIds.length];
		
		for(int i=0;i<cartIds.length;i++) {
			int cartId = Integer.parseInt(cartIds[i]);
			index[i]=cartId;
		}
		
		//1.인덱스 제일 큰거 부터 삭제
		for(int i=index.length-1;i>-1;i--) {
			cartbox.remove(index[i]-1);
		}
	
		req.getSession().setAttribute("cartbox",cartbox);
	}

	@Override
	public void cartPay(HttpServletRequest req, Model model) {

		int insertCnt=-99;
		
		String[] cartIds=req.getParameter("cartId").split(",");
		int fee = Integer.parseInt(req.getParameter("fee"));
			
		String id = (String)req.getSession().getAttribute("customerID");
		
		CustomerDTO dto3 = dao2.getCustomerDetail(id);
		
		OrderDTO dto2=new OrderDTO();
		
		List<CartDTO> cartbox = (List<CartDTO>) req.getSession().getAttribute("cartbox");
		int[] index=new int[cartIds.length];
		
		for(int i=0;i<cartIds.length;i++) {
			int cartId = Integer.parseInt(cartIds[i]);
			index[i]=cartId;
		}
		
		if(fee > 0) {
			//1.인덱스 제일 큰거 부터 주문입력
			for(int i=index.length-1;i>-1;i--) {
				CartDTO dto = cartbox.get(i);
				
				dto2.setPdName(dto.getPdName());
				dto2.setBrand(dto.getBrand());
				dto2.setPdsize(dto.getPdsize());
				dto2.setTotalPrice(dto.getPrice()+fee/index.length);
				dto2.setQuantity(dto.getQuantity());
				dto2.setOrderStatus("구매요청");
				dto2.setCusName(dto3.getName());
				
				insertCnt = dao.InsertOrder(dto2);
						
			}
		} else {
			for(int i=index.length-1;i>-1;i--) {
				CartDTO dto = cartbox.get(i);
				
				dto2.setPdName(dto.getPdName());
				dto2.setBrand(dto.getBrand());
				dto2.setPdsize(dto.getPdsize());
				dto2.setTotalPrice(dto.getPrice());
				dto2.setQuantity(dto.getQuantity());
				dto2.setOrderStatus("구매요청");
				dto2.setCusName(dto3.getName());
				
				insertCnt = dao.InsertOrder(dto2);
						
			}			
		}
		
		//1.인덱스 제일 큰거 부터 삭제
		for(int i=index.length-1;i>-1;i--) {
			cartbox.remove(i);
		}
		
		req.getSession().setAttribute("cartbox",cartbox);
		
		model.addAttribute("insertCnt", insertCnt);	

	}
	
}
