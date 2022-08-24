package spring.mvc.kyj.dao;

import java.util.List;
import java.util.Map;

import spring.mvc.kyj.dto.ChartDTO;
import spring.mvc.kyj.dto.CustomerDTO;
import spring.mvc.kyj.dto.OrderDTO;

public interface OrderDAO {
		
	//DB에 주문정보 입력
	public int InsertOrder(OrderDTO dto);
	
	//DB에서 모든 주문정보 검색
	public List<OrderDTO> orderList(Map<String, Object> map);
	
	//DB에서 모든 주문정보 갯수 검색
	public int orderCnt();
	
	//DB에서 특정회원의 주문정보 검색
	public List<OrderDTO> cusOrderList(String name);
	
	//DB에서 특정 주문정보 검색
	public OrderDTO selectOrder(int orderNo);
	
	//DB에 재고정보 업데이트(결제승인)
	public int stockUpdate(OrderDTO dto);
	
	//DB에 주문정보 업데이트
	public int orderUpdate(Map<String, Object> map);
	
	//DB에서 모든 환불요청 정보 검색
	public List<OrderDTO> refundList(Map<String, Object> map);
	
	//DB에서 환불요청 갯수 구하기
	public int refundCnt();
	
	//DB에서 재고정보 업데이트(환불승인)
	public int stockUpdate2(OrderDTO dto);
		
	//DB에서 결제승인 주문정보 검색(결산내역)
	public List<OrderDTO> saleHistoryList(Map<String, Object> map);
	
	//DB에서 결제승인 갯수 구하기(결산용)
	public int payPermitCnt();
	
	//DB에서 월별 매출 검색(결산차트)
	public List<ChartDTO> saleChart();	
}
