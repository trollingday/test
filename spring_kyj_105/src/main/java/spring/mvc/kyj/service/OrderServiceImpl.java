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

	//즉시구매 상세페이지를 보여준다.
	@Override
	public CustomerDTO purchasingDetail(String strId) {
		return dao2.getCustomerDetail(strId);		
	}
	
	@Override
	public int orderInsert(OrderDTO dto) {
		return dao.InsertOrder(dto);				
	}

    //관리자 주문목록을 보여준다.
	@Override
	public void orderList(HttpServletRequest req, Model model) {
				
		System.out.println("서비스 - orderList");
		
		String pageNum=req.getParameter("pageNum");
	
		Pagination paging = new Pagination(pageNum);
		
		//전체 게시글 갯수 카운트
		int total=dao.orderCnt();
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("start", start);
		map.put("end", end);
		
		//5단계 
		List<OrderDTO> OrderBox = dao.orderList(map);
			
		//6단계 
		model.addAttribute("OrderBox", OrderBox);
		model.addAttribute("paging",paging);		
		
	}
	
	//결제 승인을 한다.
	@Override
	public void payPermit(HttpServletRequest req, Model model) {
		
		System.out.println("서비스 - payPermit");
		
		int payResult = -99;
		
		int orderNo=Integer.parseInt(req.getParameter("orderNo"));
		String orderState = req.getParameter("orderState");
		
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
				
				int updateCnt2 = dao.orderUpdate(map);	
				payResult = 1;
			} else {
				payResult = -1;
			}
		}		
		
		model.addAttribute("payResult",payResult);
	}
	
	//결제취소를 한다.(재고가 없으면)
	@Override
	public void payCancel(HttpServletRequest req, Model model) {
		
		System.out.println("서비스 - payCancel");
		
		int payResult=-99;
		
		int orderNo=Integer.parseInt(req.getParameter("orderNo"));
		String orderState = req.getParameter("orderState");
		
		if(orderState.equals("구매요청")) {
											
			String state="결제취소";
			
			Map<String, Object> map=new HashMap<String, Object>();
			
			map.put("orderNo", orderNo);
			map.put("state", state);
			
			int updateCnt = dao.orderUpdate(map);	
			payResult=0;		
		}		
		
		model.addAttribute("payResult",payResult);
	}

	//고객 주문목록 보여준다.
	@Override
	public void cusOrderList(HttpServletRequest req, Model model) {
		
		System.out.println("서비스 - cusOrderList");
		
		String strId = (String)req.getSession().getAttribute("customerID");
		
		CustomerDTO dto = dao2.getCustomerDetail(strId);
		
		List<OrderDTO> OrderBox = dao.cusOrderList(dto.getName());
			
		model.addAttribute("OrderBox", OrderBox);		
		
	}
	
	//구매취소를 한다. (결제승인 되기전에만 가능)
	@Override
	public void purchasedCancel(HttpServletRequest req, Model model) {
		
		System.out.println("서비스 - purchasedCancel");
		
		int buyResult=-99;
		
		//1.주문번호 받고
		int orderNo=Integer.parseInt(req.getParameter("orderNo"));
		String orderState = req.getParameter("orderState");
		
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

	//환불요청을 한다. (결제승인 후에 가능)
	@Override
	public void refundReq(HttpServletRequest req, Model model) {
		
		System.out.println("서비스 - refundReq");
		
		int buyResult=-99;
		
		//1.주문번호 받고
		int orderNo=Integer.parseInt(req.getParameter("orderNo"));
		String orderState = req.getParameter("orderState");
		
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

	//환불 요청 목록을 보여준다.
	@Override
	public void refundList(HttpServletRequest req, Model model) {
		
		System.out.println("서비스 - refundList");
		
		String pageNum=req.getParameter("pageNum");
	
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

	//환불요청 승인을 한다.
	@Override
	public void refundPermit(HttpServletRequest req, Model model) {
		
		System.out.println("서비스 - refundPermit");
		
		int refundResult = -99;
		
		int orderNo=Integer.parseInt(req.getParameter("orderNo"));
		String orderState = req.getParameter("orderState");
		
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
	
	//환불요청 거절을 한다.
	@Override
	public void refundReject(HttpServletRequest req, Model model) {

		System.out.println("서비스 - refundReject");
		
		int refundResult = -99;
		
		//1.주문번호 받고
		int orderNo=Integer.parseInt(req.getParameter("orderNo"));
		String orderState = req.getParameter("orderState");
		
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

	//결산내역을 보여준다.
	@Override
	public void saleHistory(HttpServletRequest req, Model model) {
		
		System.out.println("서비스 - saleHistory");

		String pageNum=req.getParameter("pageNum");

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
	
	//결산 차트를 보여준다.
	@Override
	public void saleChart(HttpServletRequest req, Model model) {
		
		System.out.println("서비스 - saleChart");
		
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
				
				if(month==1) {
					totalPrice[0] = chartBox.get(i).getTotalPrice();
				}
				else if(month==2) {
					totalPrice[1] = chartBox.get(i).getTotalPrice();
				}
				else if(month==3) {
					totalPrice[2] = chartBox.get(i).getTotalPrice();
				}
				else if(month==4) {
					totalPrice[3] = chartBox.get(i).getTotalPrice();
				}
				else if(month==5) {
					totalPrice[4] = chartBox.get(i).getTotalPrice();
				}
				else if(month==6) {
					totalPrice[5] = chartBox.get(i).getTotalPrice();
				}
				else if(month==7) {
					totalPrice[6] = chartBox.get(i).getTotalPrice();
				}
				else if(month==8) {
					totalPrice[7] = chartBox.get(i).getTotalPrice();
				}
				else if(month==9) {
					totalPrice[8] = chartBox.get(i).getTotalPrice();
				}
				else if(month==10) {
					totalPrice[9] = chartBox.get(i).getTotalPrice();
				}
				else if(month==11) {
					totalPrice[10] = chartBox.get(i).getTotalPrice();
				}
				else if(month==12) {
					totalPrice[11] = chartBox.get(i).getTotalPrice();
				} 
						
			} else {
				break;
			}
		}
		
		model.addAttribute("totalPrice", totalPrice);
	}

	//장바구니 목록을 보여준다.
	@Override
	public void cartList(HttpServletRequest req, Model model) {

		System.out.println("서비스 - cartList");
		
		//deliveryfeeDTO box=new deliveryfeeDTO();
		//int charge = box.getCharge();

		//model.addAttribute("charge", charge);
	}

	//장바구니 담기
	@Override
	public void cartAdd(HttpServletRequest req, Model model) {

		System.out.println("서비스 - cartAdd");
		
		//1.productDTO에 상품정보를 집어넣고, 그걸 리스트에 집어넣는다.
		String pdImg = req.getParameter("pdImg");
		String pdName = req.getParameter("pdName");
		String brand = req.getParameter("brand");
		int pdsize = Integer.parseInt(req.getParameter("pdsize"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int price = Integer.parseInt(req.getParameter("price"));
		
		//deliveryfeeDTO box=new deliveryfeeDTO();
		//int charge = box.getCharge();
		
		CartDTO dto=new CartDTO();
		
		//dto.setPdImg(pdImg);
		dto.setPdName(pdName);
		dto.setBrand(brand);
		dto.setPdsize(pdsize);
		dto.setQuantity(quantity);
		dto.setPrice(price);
		
		List<CartDTO> cartbox = (List<CartDTO>) req.getSession().getAttribute("cartbox");
		
		cartbox.add(dto);
		req.getSession().setAttribute("cartbox",cartbox);
		//model.addAttribute("charge", charge);				
	}

	//장바구니 빼기
	@Override
	public void cartRemove(HttpServletRequest req, Model model) {

		System.out.println("서비스 - cartRemove");
		
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
		
		//deliveryfeeDTO box=new deliveryfeeDTO();
		//int charge = box.getCharge();
		
		req.getSession().setAttribute("cartbox",cartbox);
		//model.addAttribute("charge", charge);
	}

	//장바구니 담은 상품 결제
	@Override
	public void cartPay(HttpServletRequest req, Model model) {
		
		System.out.println("서비스 - cartPay");
		
		int insertCnt=-99;
		
		String[] cartIds=req.getParameter("cartId").split(",");
		
		//deliveryfeeDTO box=new deliveryfeeDTO();
		//int charge = box.getCharge();
			
		String id = (String)req.getSession().getAttribute("customerID");
		
		CustomerDTO dto3 = dao2.getCustomerDetail(id);
		
		OrderDTO dto2=new OrderDTO();
		
		List<CartDTO> cartbox = (List<CartDTO>) req.getSession().getAttribute("cartbox");
		int[] index=new int[cartIds.length];
		
		for(int i=0;i<cartIds.length;i++) {
			int cartId = Integer.parseInt(cartIds[i]);
			index[i]=cartId;
		}
		
		//1.인덱스 제일 큰거 부터 주문입력
		for(int i=index.length-1;i>-1;i--) {
			CartDTO dto = cartbox.get(i);
			
			dto2.setPdName(dto.getPdName());
			dto2.setBrand(dto.getBrand());
			dto2.setPdsize(dto.getPdsize());
			//dto2.setPrice(dto.getPrice()+charge/index.length);
			dto2.setQuantity(dto.getQuantity());
			dto2.setOrderStatus("구매요청");
			dto2.setCusName(dto3.getName());
			
			insertCnt = dao.InsertOrder(dto2);
			System.out.println("cartPay - insertCnt : "+insertCnt);
					
		}
		
		//1.인덱스 제일 큰거 부터 삭제
		for(int i=index.length-1;i>-1;i--) {
			cartbox.remove(i);
		}
		
		req.getSession().setAttribute("cartbox",cartbox);
		
		model.addAttribute("insertCnt", insertCnt);	
	}
	
}
